package ParkingLot.Services;

import ParkingLot.Exception.NoParkingSlotAvailableException;
import ParkingLot.Repositry.TicketRepository;
import ParkingLot.Strategy.SlotAssignmentStrategy;
import ParkingLot.models.*;

import java.util.Date;


//multiple controller can use same service and controllers are bound to their DTOs. if we also use DTOs in servic,e
// but as we know multiple controller can call a same service, so it will create confusion for services , that of which
// controller DTO is to be used by it(service).
public class TicketService {
    private GateService gateService;
    private VehicleService vehicleService;

    private SlotAssignmentStrategy slotAssignmentStrategy;
    private TicketRepository ticketRepository;
    public TicketService(GateService gateService,VehicleService vehicleService,
                         SlotAssignmentStrategy slotAssignmentStrategy , TicketRepository ticketRepository){
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }


    public Ticket generateTicket(String VehicleNumber, VehicleType vehicleType, long gateID ) throws NoParkingSlotAvailableException {
        //here is is better to take one parameter(an options object)

        // steps requried to generate ticket

        //1. Get the gate -> will require GateService , GateRepositry
        Gate gate = gateService.getGate(gateID);

        //2. Get the vehicle/ register the vehicle -> require VehicleService , vehicleRepositry
        Vehicle vehicle = vehicleService.getVehicle(VehicleNumber); // if vehicle is present in repositry

        if(vehicle == null){  // if vehicle is new entry
            vehicle = vehicleService.registerVehicle(VehicleNumber,vehicleType);
        }

        //3. Assign parking slot -> will require ParkingSlotService
        Slot  assignedSlot = slotAssignmentStrategy.assignSlot(vehicle.getVehicleType(), gate);
        if(assignedSlot == null){
            throw new NoParkingSlotAvailableException("parking slot not available");
        }

        //4.save the ticket to ticketRepositry and  return the ticket

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setVehicle(vehicle);
        ticket.setSlot(assignedSlot);

        assignedSlot.setStatus(SlotStatus.OCCUPIED);// set the status of this slot to occupied now

        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;

    }
}
