package com.logintoken.jwttoken.Controller;

import com.logintoken.jwttoken.ApiResponse.UserDeletedResponse;
import com.logintoken.jwttoken.Entity.User;
import com.logintoken.jwttoken.Service.Implement.UserServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/UserDetails")
public class UserController {
    @Autowired
    private UserServiceImplement userService;


    @PutMapping("/{uid}")
    public ResponseEntity<User> updateUser(@RequestBody User userDetails, @PathVariable Integer uid){
        return new ResponseEntity<>(this.userService.updateUser(userDetails,uid),HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<UserDeletedResponse> deleteUser(@PathVariable String email){
        this.userService.Deleteuser(email);
        return new ResponseEntity<>(new UserDeletedResponse("USER DELETED SUCCESSFULLY!"),HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable(name="email") String Email){
        return new ResponseEntity<>(this.userService.getUserByEmail(Email),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(this.userService.getAllUser(),HttpStatus.OK);
    }


}
