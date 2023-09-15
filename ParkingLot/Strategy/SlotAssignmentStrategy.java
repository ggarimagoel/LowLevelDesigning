package ParkingLot.Strategy;

import ParkingLot.models.Gate;
import ParkingLot.models.Slot;
import ParkingLot.models.VehicleType;

import java.util.List;

public interface SlotAssignmentStrategy {
    public Slot assignSlot(VehicleType vehicleType, Gate gate);
}
