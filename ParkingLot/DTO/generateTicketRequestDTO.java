package ParkingLot.DTO;

import ParkingLot.models.VehicleType;

// each controller will have their own DTO
public class generateTicketRequestDTO {
    private long gateID;
    private  String VehicleNumber;
    private VehicleType vehicleType;
    public long getGateID() {
        return gateID;
    }
    public void setGateID(long gateID) {
        this.gateID = gateID;
    }
    public String getVehicleNumber() {
        return VehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
