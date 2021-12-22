package services;

import entities.Rides;
import entities.Users;
import repositories.RidesRepo;
import repositories.UserRepo;

import java.util.HashMap;
import java.util.Map;

public class PrintRideStatusService {

    public void printRides(RidesRepo ridesRepo, UserRepo userRepo){

        HashMap<String, Rides> ridesMap = ridesRepo.getRidesMap();

        HashMap<String, Users> usersHashMap = userRepo.getUsersHashMap();

        for(Map.Entry<String, Users> entry : usersHashMap.entrySet()){

            Users user = entry.getValue();
            HashMap<Rides, Boolean> ridesOffered = user.getRidesOffered(); //STORES if the offered ride has ended
            HashMap<Rides, Boolean> ridesTaken = user.getRidesTaken();

            int ridesOfferedCount = 0;
            int ridesTakenCount = 0;

            for(Map.Entry<Rides, Boolean> ridesOfferedEntry : ridesOffered.entrySet()){
                if (ridesOfferedEntry.getValue())
                    ridesOfferedCount++;
            }

            for(Map.Entry<Rides, Boolean> ridesTakenEntry : ridesTaken.entrySet()){
                if (ridesTakenEntry.getValue())
                    ridesTakenCount++;
            }

            System.out.println(user.getName() + ": " + ridesTakenCount + " Taken, " + ridesOfferedCount + " Offered");
        }

    }

}
