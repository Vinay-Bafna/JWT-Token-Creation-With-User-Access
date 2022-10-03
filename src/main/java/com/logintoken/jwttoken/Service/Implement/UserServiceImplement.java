package com.logintoken.jwttoken.Service.Implement;

import com.logintoken.jwttoken.Config.AppConstant;
import com.logintoken.jwttoken.Entity.Role;
import com.logintoken.jwttoken.Entity.User;
import com.logintoken.jwttoken.ExceptionHandler.EmailResourceNotFoundException;
import com.logintoken.jwttoken.ExceptionHandler.ResourceNotFoundException;
import com.logintoken.jwttoken.Repository.RoleRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.logintoken.jwttoken.Repository.UserRepository;
import com.logintoken.jwttoken.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepo;
	@Autowired
    private UserRepository userDetailsRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepo roleRepo;


    @Override
    public void Deleteuser(String Email) {
        User user = this.userDetailsRepository.findByEmail(Email).orElseThrow(() -> new EmailResourceNotFoundException(Email));
        this.userDetailsRepository.delete(user);
    }

    @Override
    public User updateUser(User userDetails, Integer uid) {

        User userFound = this.userDetailsRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User", "Id", uid));
        userFound.setName(userDetails.getUsername());
        userFound.setPassword(this.passwordEncoder.encode(userDetails.getPassword()));
        userFound.setEmail(userDetails.getEmail());
        User saveUser = this.userDetailsRepository.save(userFound);
        return saveUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listOfUser = this.userDetailsRepository.findAll();
        return  listOfUser.stream().collect(Collectors.toList());
    }

    @Override
    public User getUserByEmail(String Email) {
        User user = this.userDetailsRepository.findByEmail(Email).orElseThrow(() -> new EmailResourceNotFoundException(Email));
        return user;
    }
    @Override
    public User registerNewUser(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepo.findById(AppConstant.NORMAL_USER).get();
        user.getRoles().add(role);
        //user.setRoles(user.getId(),"role_Normal");
        User newuser = this.userRepo.save(user);
        return newuser;
    }

}
