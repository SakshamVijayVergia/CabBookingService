package com.example.CabBookingService.cabbooking.Services;

import com.example.CabBookingService.cabbooking.Models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    // Method to add a new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // Method to get the list of all users // can be used for future requirements
    public List<User> getUsers() {
        return users;
    }

}
