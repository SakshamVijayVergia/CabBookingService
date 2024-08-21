package com.example.CabBookingService.cabbooking.Models;

import lombok.Data;

@Data
public class User {
    private String name;
    private String gender;
    private int age;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}
