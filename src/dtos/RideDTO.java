package dtos;

public class RideDTO {

    String rideIdForEnding;
    String rideGiver;
    String origin;
    int availableSeats;
    String vehicleName;
    String vehicleId;
    String destination;

    public RideDTO(String rideIdForEnding, String rideGiver, String origin, int availableSeats, String vehicleName, String vehicleId, String destination) {
        this.rideIdForEnding = rideIdForEnding;
        this.rideGiver = rideGiver;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.vehicleName = vehicleName;
        this.vehicleId = vehicleId;
        this.destination = destination;
    }

    public String getRideIdForEnding() {
        return rideIdForEnding;
    }

    public String getRideGiver() {
        return rideGiver;
    }

    public String getOrigin() {
        return origin;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDestination() {
        return destination;
    }
}
