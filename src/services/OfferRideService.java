package services;

import dtos.RideDTO;
import entities.Rides;
import entities.Users;
import entities.Vehicle;
import repositories.RidesRepo;
import repositories.UserRepo;
import repositories.VehicleRepo;

import java.util.HashMap;

public class OfferRideService {

    public void offerRide(RideDTO rideDetails, RidesRepo ridesRepo, UserRepo userRepo, VehicleRepo vehicleRepo){

        Rides ride = ridesRepo.saveRideDetails(rideDetails);

        Users user = userRepo.findUserById(ride.getRideGiver());

        HashMap<Rides, Boolean> ridesOffered = user.getRidesOffered();

        if (ridesOffered == null)
            ridesOffered = new HashMap<>();

        ridesOffered.put(ride, false);

        //need a vehicle repo which gives vehicle by ID
        Vehicle vehicle =  vehicleRepo.findVehicleById(ride.getVehicleId());
        HashMap<Vehicle, Boolean> vehicleMap = user.getVehicleMap();

        if (vehicleMap == null){
            System.out.println(ride.getRideGiver() + " does not own " + vehicle.getVehicleName());
            return;
        }else if (!vehicleMap.get(vehicle)){
            System.out.println(ride.getRideGiver() + " does not have " + vehicle.getVehicleName() + " available.");
            return;
        }

        vehicleMap.put(vehicle, false);

        user.setVehicleMap(vehicleMap);

        user.setRidesOffered(ridesOffered);
        userRepo.saveUser(user);

    }

}
