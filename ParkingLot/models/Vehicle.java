package ParkingLot.models;

public class Vehicle extends Base{
    private  String VehicleNumber;
    private VehicleType vehicleType;


    public Vehicle(String VehicleNumber, VehicleType vehicleType){
        this.VehicleNumber = VehicleNumber;
        this.vehicleType = vehicleType;
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
