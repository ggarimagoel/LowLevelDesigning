package ParkingLot.Repositry;

import ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
     /*
    We can have Map as DB and use to push/retrive data
     */

    Map<String , Vehicle> vehicleData;

    public VehicleRepository(){
        this.vehicleData = new HashMap<>();
    }
    public Vehicle addVehicle(Vehicle vehicle){
        vehicleData.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
    public Vehicle getVehicle(String number){
        return vehicleData.get(number);
    }
}
