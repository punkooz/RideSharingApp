package services;

import dtos.UserDTO;
import entities.Users;
import entities.Vehicle;
import repositories.UserRepo;
import repositories.VehicleRepo;

import java.util.HashMap;

public class AddUserVehicle {

    public void addVehicle(Vehicle vehicle, UserRepo userRepo, VehicleRepo vehicleRepo){

        vehicleRepo.saveVehicleDetails(vehicle);

        String owner = vehicle.getOwner();

        Users user = userRepo.findUserById(owner);

        HashMap<Vehicle, Boolean> vehicleMap = user.getVehicleMap();

        if (vehicleMap == null)
            vehicleMap = new HashMap<>();

        vehicleMap.put(vehicle, true);

        user.setVehicleMap(vehicleMap);
        userRepo.saveUser(user);

    }

}
