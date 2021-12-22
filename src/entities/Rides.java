package entities;

import java.util.ArrayList;
import java.util.List;

public class Rides {

    String rideIdForEnding;
    String rideGiver;
    String origin;
    int availableSeats;
    String vehicleName;
    String vehicleId;
    String destination;
    String status;
    List<Users> rideTakerList;

    public Rides(String rideIdForEnding, String rideGiver, String origin, int availableSeats, String vehicleName, String vehicleId, String destination) {
        this.rideIdForEnding = rideIdForEnding;
        this.rideGiver = rideGiver;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.vehicleName = vehicleName;
        this.vehicleId = vehicleId;
        this.destination = destination;
        status = "started";
        this.rideTakerList = new ArrayList<>();
    }

    public List<Users> getRideTakerList() {
        return rideTakerList;
    }

    public void setRideTakerList(List<Users> rideTakerList) {
        this.rideTakerList = rideTakerList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRideIdForEnding() {
        return rideIdForEnding;
    }

    public String getRideGiver() {
        return rideGiver;
    }

    public void setRideGiver(String rideGiver) {
        this.rideGiver = rideGiver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
