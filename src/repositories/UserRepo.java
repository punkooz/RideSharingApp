package repositories;

import dtos.UserDTO;
import entities.Users;

import java.util.HashMap;

public class UserRepo {

    HashMap<String, Users> usersHashMap;

    public UserRepo() {
        this.usersHashMap = new HashMap<>();
    }

    public void saveUserDetails(UserDTO userDetails){
        String name = userDetails.getName();
        String age = userDetails.getAge();
        String gender = userDetails.getGender();

        Users user = new Users(name, age, gender);
        usersHashMap.put(user.getName(), user);
    }

    public void saveUser(Users users){
        usersHashMap.put(users.getName(), users);
    }

    public Users findUserById(String id){
        return usersHashMap.get(id);
    }

    public HashMap<String, Users> getUsersHashMap() {
        return usersHashMap;
    }
}
