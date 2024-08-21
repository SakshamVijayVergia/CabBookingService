package com.example.CabBookingService.cabbooking.Services;

import com.example.CabBookingService.cabbooking.Models.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    // Method to get the list of all users // can be used for future requirements
    private final List<User> users = new ArrayList<>();
    // Method to add a new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

}
