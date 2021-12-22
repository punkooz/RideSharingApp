package dtos;

public class SelectRideDTO {

    String rideRequestor;
    String origin;
    String destination;
    int seats;
    String strategy;

    public SelectRideDTO(String rideRequestor, String origin, String destination, int seats, String strategy) {
        this.rideRequestor = rideRequestor;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
        this.strategy = strategy;
    }

    public String getRideRequestor() {
        return rideRequestor;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public String getStrategy() {
        return strategy;
    }
}
