//package ParkingLot.Services;
//
//import ParkingLot.Repositry.ParkingLotRepository;
//import ParkingLot.Strategy.SlotAssignmentStrategy;
//import ParkingLot.models.Gate;
//import ParkingLot.models.Slot;
//import ParkingLot.models.Vehicle;
//
//import java.util.List;
//
//public class ParkingLotService {
//    private SlotAssignmentStrategy slotAssignmentStrategy;
//    private ParkingLotRepository parkingLotRepository;
//
//    public ParkingLotService(SlotAssignmentStrategy slotAssignmentStrategy,ParkingLotRepository parkingLotRepository){
//        this.parkingLotRepository = parkingLotRepository;
//        this.slotAssignmentStrategy = slotAssignmentStrategy;
//    }
//    public ParkingLotService(SlotAssignmentStrategy slotAssignmentStrategy){
//        this.slotAssignmentStrategy = slotAssignmentStrategy;
//    }
//    public Slot getParkingSlot(Vehicle vehicle, Gate gate){
//            List<Slot> parkingSlotList = parkingLotRepository.getAllSlots();
//            return slotAssignmentStrategy.assignSlot(vehicle.getVehicleType(),gate,parkingSlotList);
//    }
//}
