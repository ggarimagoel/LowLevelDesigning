package ParkingLot.Strategy;

import ParkingLot.Repositry.ParkingLotRepository;
import ParkingLot.Repositry.ParkingSlotRepository;
import ParkingLot.models.*;

import java.util.List;

public class FirstSlotAvailableStrategy implements SlotAssignmentStrategy{
    private ParkingLotRepository parkingLotRepository;
    private ParkingSlotRepository parkingSlotRepository;

    public  FirstSlotAvailableStrategy(ParkingLotRepository parkingLotRepository,ParkingSlotRepository parkingSlotRepository){
    this.parkingLotRepository = parkingLotRepository;
    this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public Slot assignSlot(VehicleType vehicleType, Gate gate) {

        //1. get ParkingLot for this gate
         ParkingLot parkingLot = parkingLotRepository.getParkingLotByGate(gate);

        //2. get List<Slot> of parking lot
        List<Slot> allParkingSlots = parkingSlotRepository.getAllParkingSlotsOfParkingLot(parkingLot);

        //3. loop through parking slots and pick the first available slot which supports this vehicle
        for(Slot slot : allParkingSlots){
            if(slot.getStatus().equals(SlotStatus.AVAILABLE)&&
            slot.getSupportedVehicleTypes().contains(vehicleType)){
                return slot;
            }
        }
        return null;
    }
}
