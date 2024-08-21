package com.example.CabBookingService.cabbooking.Models;

import lombok.Data;

@Data
public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private Location currentLocation;
    private boolean available;

    public Driver(String name, String gender, int age, String vehicleDetails, Location currentLocation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
        this.available = true; // Default to available when onboarding
    }
}
