package com.logintoken.jwttoken.Service;

import com.logintoken.jwttoken.Entity.User;
import java.util.List;

public interface UserService {


    void Deleteuser(String Email);
    User updateUser(User userDetails, Integer uid);
    List<User> getAllUser();
    User getUserByEmail(String Email);

    User registerNewUser(User userDto);
}
