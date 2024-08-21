package com.example.CabBookingService.cabbooking.Services;

import com.example.CabBookingService.cabbooking.Models.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

}
