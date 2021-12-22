package entities;

import java.util.HashMap;
import java.util.List;

public class Users {

    String name;
    String age;
    String gender;
    HashMap<Vehicle, Boolean> vehicleMap; //stores if the vehicle is available
    HashMap<Rides, Boolean> ridesOffered; //STORES if the offered ride has ended
    HashMap<Rides, Boolean> ridesTaken; //stores if the taken RIDE has ended

    public Users(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.vehicleMap = new HashMap<>();
        this.ridesOffered = new HashMap<>();
        this.ridesTaken = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HashMap<Vehicle, Boolean> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(HashMap<Vehicle, Boolean> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public HashMap<Rides, Boolean> getRidesOffered() {
        return ridesOffered;
    }

    public void setRidesOffered(HashMap<Rides, Boolean> ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public HashMap<Rides, Boolean> getRidesTaken() {
        return ridesTaken;
    }

    public void setRidesTaken(HashMap<Rides, Boolean> ridesTaken) {
        this.ridesTaken = ridesTaken;
    }
}
