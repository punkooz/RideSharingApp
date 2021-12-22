package services;

import dtos.SelectRideDTO;
import entities.Rides;
import entities.Users;
import entities.Vehicle;
import repositories.RidesRepo;
import repositories.UserRepo;
import repositories.VehicleRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectRideService {

    public void select(SelectRideDTO selectRideDTO, UserRepo userRepo, RidesRepo ridesRepo, VehicleRepo vehicleRepo){

        String rideRequestor = selectRideDTO.getRideRequestor();
        String origin = selectRideDTO.getOrigin();
        String destination = selectRideDTO.getDestination();
        int seats = selectRideDTO.getSeats();
        String strategy = selectRideDTO.getStrategy();

        HashMap<String, Rides> ridesMap = ridesRepo.getRidesMap();

        String rideId = "";

        List<Rides> ridesList = new ArrayList<>();
        for (Map.Entry<String, Rides> entry : ridesMap.entrySet()){

            Rides ride = entry.getValue();

            if (ride.getOrigin().equals(origin) && ride.getDestination().equals(destination) && ride.getAvailableSeats() >= seats && ride.getStatus().equals("started")){
                ridesList.add(ride);
            }

        }


        if (ridesList.size() == 0){
            System.out.println("No Rides Found" + " for : " + rideRequestor);
        }else{

            Rides selectedride = null;
            int mostVacant = Integer.MIN_VALUE;
            switch (strategy){

                case "Most Vacant":
                    for (Rides rides : ridesList){
                        if (rides.getAvailableSeats() > mostVacant){
                            mostVacant = rides.getAvailableSeats();
                            selectedride = rides;
                        }
                    }
                    selectedride.setAvailableSeats(selectedride.getAvailableSeats() - seats);
                    break;
                default:
                    String[] arr = strategy.split("=");
                    for (Rides ride : ridesList) {
                        if (ride.getVehicleName().equals(arr[1])) {
                            ride.setAvailableSeats(ride.getAvailableSeats() - seats);
                            selectedride = ride;
                            break;
                        }
                    }
            }

            if (selectedride == null){
                System.out.println("No Rides Found " + "for : " + rideRequestor);
                return;
            }

            Users passenger = userRepo.findUserById(rideRequestor);

            if (passenger == null){
                System.out.println("passenger does not exists");
            }

            HashMap<Rides, Boolean> ridesTaken = passenger.getRidesTaken();

            if (ridesTaken == null)
                ridesTaken = new HashMap<>();

            ridesTaken.put(selectedride, false);

            List<Users> rideTakerList = selectedride.getRideTakerList();

            if (rideTakerList == null){
                rideTakerList = new ArrayList<>();
            }

            rideTakerList.add(passenger);

            selectedride.setRideTakerList(rideTakerList);

            passenger.setRidesTaken(ridesTaken);

            userRepo.saveUser(passenger);

            ridesRepo.saveRide(selectedride);

            System.out.println("Selected Ride with Id: " + selectedride.getRideIdForEnding() + " for : " + rideRequestor);
        }

    }

}
