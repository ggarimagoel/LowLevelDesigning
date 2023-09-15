package ParkingLot.models;

import java.util.List;

public class Slot extends Base{
    private int SlotNumber;
    private SlotStatus status;
    private List<VehicleType> supportedVehicleTypes;
    private Levels level;
//    private List<VehicleType> vehicalTypeList;



    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        SlotNumber = slotNumber;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }


}
