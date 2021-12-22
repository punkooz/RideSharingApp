package repositories;

import entities.Vehicle;

import java.util.HashMap;

public class VehicleRepo {

    HashMap<String, Vehicle> vehicleHashMap;

    public VehicleRepo() {
        this.vehicleHashMap = new HashMap<>();
    }

    public void saveVehicleDetails(Vehicle vehicle) {
        vehicleHashMap.put(vehicle.getId(), vehicle);
    }

    public Vehicle findVehicleById(String id){
        return vehicleHashMap.get(id);
    }
}
