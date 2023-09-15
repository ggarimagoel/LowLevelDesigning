package ParkingLot.Services;

import ParkingLot.Repositry.VehicleRepository;
import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleType;

public class VehicleService {
    private VehicleRepository vehicleRepositry;


    // if vehicle is already registered in dataBase , we fetch the data from repositry.
        public Vehicle getVehicle(String number){
        return vehicleRepositry.getVehicle(number);
    }

    // if not we register it as new vehicle in the database.

    public Vehicle registerVehicle(String number, VehicleType type){
        return vehicleRepositry.addVehicle(new Vehicle(number,type));
    }
}
