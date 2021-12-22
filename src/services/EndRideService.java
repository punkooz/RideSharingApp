package services;

import entities.Rides;
import entities.Users;
import entities.Vehicle;
import repositories.RidesRepo;
import repositories.UserRepo;
import repositories.VehicleRepo;

import java.util.HashMap;
import java.util.List;

public class EndRideService {

    public void endRide(String rideIdForEnding, RidesRepo ridesRepo, UserRepo userRepo, VehicleRepo vehicleRepo){

        Rides ride = ridesRepo.findRideById(rideIdForEnding);

        ride.setStatus("ended");

        Users user = userRepo.findUserById(ride.getRideGiver());

        Vehicle vehicle = vehicleRepo.findVehicleById(ride.getVehicleId());

        HashMap<Vehicle, Boolean> vehicleMap = user.getVehicleMap(); //stores if the vehicle is available
        HashMap<Rides, Boolean> ridesOffered = user.getRidesOffered(); //STORES if the offered ride has ended
        HashMap<Rides, Boolean> ridesTaken = user.getRidesTaken();

        if (vehicleMap == null || !vehicleMap.containsKey(vehicle)){
            System.out.println(ride.getRideGiver() + " does not own " + vehicle.getVehicleName());
            return;
        }

        if (ridesOffered != null && ridesOffered.containsKey(ride)){
            ridesOffered.put(ride, true);
        }

        if (ridesTaken != null && ridesTaken.containsKey(ride)){
            ridesTaken.put(ride, true);
        }

        List<Users> rideTakerList = ride.getRideTakerList();

        for (Users u : rideTakerList){
            HashMap<Rides, Boolean> ridesTakenByPassenger = u.getRidesTaken();
            if (ridesTakenByPassenger != null){
                ridesTakenByPassenger.put(ride, true);
                u.setRidesTaken(ridesTakenByPassenger);
                userRepo.saveUser(u);
            }
        }


        vehicleMap.put(vehicle, true);
        user.setVehicleMap(vehicleMap);
        user.setRidesOffered(ridesOffered);
        user.setRidesTaken(ridesTaken);

        userRepo.saveUser(user);
        ridesRepo.saveRide(ride);
    }

}
