package repositories;

import dtos.RideDTO;
import entities.Rides;

import java.util.HashMap;

public class RidesRepo {

    HashMap<String, Rides> ridesMap;

    public RidesRepo() {
        this.ridesMap = new HashMap<>();
    }

    public Rides saveRideDetails(RideDTO rideDetails){
        String rideIdForEnding = rideDetails.getRideIdForEnding();
        String rideGiver = rideDetails.getRideGiver();
        String origin = rideDetails.getOrigin();
        int availableSeats = rideDetails.getAvailableSeats();
        String vehicleName = rideDetails.getVehicleName();
        String vehicleId = rideDetails.getVehicleId();
        String destination = rideDetails.getDestination();

        Rides ride = new Rides(rideIdForEnding, rideGiver, origin, availableSeats, vehicleName, vehicleId, destination);

        ridesMap.put(rideIdForEnding, ride);

        return ride;
    }

    public void saveRide(Rides ride){
        ridesMap.put(ride.getRideIdForEnding(), ride);
    }

    public HashMap<String, Rides> getRidesMap() {
        return ridesMap;
    }

    public Rides findRideById(String rideIdForEnding) {
        return ridesMap.get(rideIdForEnding);
    }
}
