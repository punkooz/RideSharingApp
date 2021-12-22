import controllers.RideShareAppController;
import dtos.RideDTO;
import dtos.SelectRideDTO;
import dtos.UserDTO;
import entities.Vehicle;

public class RideSharingApp {
    
    public static void main(String[] args){

        RideShareAppController rideShareAppController = new RideShareAppController();

        UserDTO userDTO1 = new UserDTO("Rohan", "M", "36");
        UserDTO userDTO2 = new UserDTO("Shashank", "M", "29");
        UserDTO userDTO3 = new UserDTO("Nandini", "F", "29");
        UserDTO userDTO4 = new UserDTO("Shipra", "F", "27");
        UserDTO userDTO5 = new UserDTO("Gaurav", "M", "29");
        UserDTO userDTO6 = new UserDTO("Rahul", "M", "35");

        //add users
        rideShareAppController.addUser(userDTO1);
        rideShareAppController.addUser(userDTO2);
        rideShareAppController.addUser(userDTO3);
        rideShareAppController.addUser(userDTO4);
        rideShareAppController.addUser(userDTO5);
        rideShareAppController.addUser(userDTO6);

        //addVehicle
        Vehicle v1 = new Vehicle("Rohan", "Swift", "KA-01-12345");
        Vehicle v2 = new Vehicle("Shashank", "Baleno", "TS-05-62395");
        Vehicle v3 = new Vehicle("Shipra", "Polo", "KA-05-41491");
        Vehicle v4 = new Vehicle("Shipra", "Activa", "KA-12-12332");
        Vehicle v5 = new Vehicle("Rahul", "XUV", "KA-05-1234");

        rideShareAppController.addVehicle(v1);
        rideShareAppController.addVehicle(v2);
        rideShareAppController.addVehicle(v3);
        rideShareAppController.addVehicle(v4);
        rideShareAppController.addVehicle(v5);

        //offerRides
        RideDTO ride1 = new RideDTO("2-a", "Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");
        RideDTO ride2 = new RideDTO("2-b", "Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore");
        RideDTO ride3 = new RideDTO("2-c", "Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        RideDTO ride4 = new RideDTO("2-d", "Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");
        RideDTO ride5 = new RideDTO("2-e", "Rahul", "Hyderabad", 5, "XUV", "KA-05-1234", "Bangalore");
        RideDTO ride6 = new RideDTO("2-f", "Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");

        rideShareAppController.offerRide(ride1);
        rideShareAppController.offerRide(ride2);
        rideShareAppController.offerRide(ride3);
        rideShareAppController.offerRide(ride4);
        rideShareAppController.offerRide(ride5);
        rideShareAppController.offerRide(ride6);

        //select rides

        SelectRideDTO selectRide1 = new SelectRideDTO("Nandini", "Bangalore", "Mysore", 1,"Most Vacant");
        SelectRideDTO selectRide2 = new SelectRideDTO("Gaurav", "Bangalore", "Mysore", 1,"Preferred Vehicle=Activa");
        SelectRideDTO selectRide3 = new SelectRideDTO("Shashank", "Mumbai", "Bangalore", 1,"Most Vacant");
        SelectRideDTO selectRide4 = new SelectRideDTO("Rohan", "Hyderabad", "Bangalore", 1,"Preferred Vehicle=Baleno");
        SelectRideDTO selectRide5 = new SelectRideDTO("Shashank", "Hyderabad", "Bangalore", 1,"Preferred Vehicle=Polo");

        rideShareAppController.selectRide(selectRide1);
        rideShareAppController.selectRide(selectRide2);
        rideShareAppController.selectRide(selectRide3);
        rideShareAppController.selectRide(selectRide4);
        rideShareAppController.selectRide(selectRide5);

        //end rides

        rideShareAppController.endRide("2-a");
        rideShareAppController.endRide("2-b");
        rideShareAppController.endRide("2-c");
        rideShareAppController.endRide("2-d");

        //printRideStatus
        rideShareAppController.printRideStatus();

    }
    
}
