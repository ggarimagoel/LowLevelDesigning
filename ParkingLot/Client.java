package ParkingLot;

import ParkingLot.Controller.TicketController;
import ParkingLot.DTO.generateTicketRequestDTO;
import ParkingLot.DTO.generateTicketResponseDTO;
import ParkingLot.Repositry.ParkingLotRepository;
import ParkingLot.Repositry.ParkingSlotRepository;
import ParkingLot.Repositry.TicketRepository;
import ParkingLot.Services.GateService;
import ParkingLot.Services.TicketService;
import ParkingLot.Services.VehicleService;
import ParkingLot.Strategy.FirstSlotAvailableStrategy;
import ParkingLot.Strategy.SlotAssignmentStrategy;
import ParkingLot.models.VehicleType;

public class Client {
    public static void main(String[] args) {
        GateService gs = new GateService();
        VehicleService vs = new VehicleService();

        ParkingLotRepository plr = new ParkingLotRepository();
        ParkingSlotRepository psr = new ParkingSlotRepository();
        TicketRepository tr = new TicketRepository();

        SlotAssignmentStrategy sas = new FirstSlotAvailableStrategy(plr, psr);

        TicketService ts = new TicketService(gs, vs, sas, tr);
        TicketController tc = new TicketController(ts);

        // Request
        generateTicketRequestDTO requestDTO = new generateTicketRequestDTO();
        requestDTO.setGateID(14);
        requestDTO.setVehicleNumber("DL02 5678");
        requestDTO.setVehicleType(VehicleType.MediumWeight);

        generateTicketResponseDTO responseDTO = tc.generateTicket(requestDTO);
      }
}

// Requirement:
//  1. Generate Ticket workflow

// Way to think
// 1. which model is it about? Ticket
// 2. TicketController, TicketService, TicketRepository


// Should TickerController methods take models as parameters and return types?
// 1. DB models should not be exposed
// 2. Try to take a single parameter in controller, so that for new parameters the code doesn't break in future
// 3.