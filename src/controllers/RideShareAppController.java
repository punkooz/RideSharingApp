package controllers;

import dtos.RideDTO;
import dtos.SelectRideDTO;
import dtos.UserDTO;
import entities.Vehicle;
import repositories.RidesRepo;
import repositories.UserRepo;
import repositories.VehicleRepo;
import services.*;

public class RideShareAppController {

    RidesRepo ridesRepo = new RidesRepo();
    VehicleRepo vehicleRepo = new VehicleRepo();
    UserRepo userRepo = new UserRepo();

    public void addUser(UserDTO userDTO){

        AddUserService addUserService = new AddUserService();
        addUserService.addUser(userDTO, userRepo);

    }

    public void addVehicle(Vehicle vehicle){

        AddUserVehicle addUserVehicle = new AddUserVehicle();

        addUserVehicle.addVehicle(vehicle, userRepo, vehicleRepo);

    }

    public void endRide(String rideId){

        EndRideService endRideService = new EndRideService();

        endRideService.endRide(rideId, ridesRepo, userRepo, vehicleRepo);

    }

    public void offerRide(RideDTO rideDTO){

        OfferRideService offerRideService = new OfferRideService();

        offerRideService.offerRide(rideDTO, ridesRepo, userRepo, vehicleRepo);

    }

    public void printRideStatus(){
        PrintRideStatusService printRideStatusService = new PrintRideStatusService();

        printRideStatusService.printRides(ridesRepo, userRepo);

    }

    public void selectRide(SelectRideDTO selectRideDTO){

        SelectRideService selectRideService = new SelectRideService();

        selectRideService.select(selectRideDTO, userRepo, ridesRepo, vehicleRepo);

    }

}
