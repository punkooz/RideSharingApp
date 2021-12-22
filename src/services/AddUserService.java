package services;

import dtos.UserDTO;
import repositories.UserRepo;

public class AddUserService {

    public void addUser(UserDTO userDetails, UserRepo userRepo){
        userRepo.saveUserDetails(userDetails);
    }

}
