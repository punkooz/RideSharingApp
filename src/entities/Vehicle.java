package entities;

public class Vehicle {

    String owner;
    String vehicleName;
    String id;

    public Vehicle(String owner, String vehicleName, String id) {
        this.owner = owner;
        this.vehicleName = vehicleName;
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
