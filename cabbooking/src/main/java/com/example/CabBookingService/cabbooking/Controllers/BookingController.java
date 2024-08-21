package com.example.CabBookingService.cabbooking.Controllers;

import com.example.CabBookingService.cabbooking.Models.Driver;
import com.example.CabBookingService.cabbooking.Models.Location;
import com.example.CabBookingService.cabbooking.Models.User;
import com.example.CabBookingService.cabbooking.Services.BookingService;
import com.example.CabBookingService.cabbooking.Services.DriverService;
import com.example.CabBookingService.cabbooking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cabbooking")
public class BookingController {

    @Autowired
    DriverService driverService;
    @Autowired
    BookingService bookingService;
    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/add_driver")
    public void addDriver(@RequestParam String name, @RequestParam String gender, @RequestParam int age,
                          @RequestParam String vehicleDetails, @RequestParam int x, @RequestParam int y) {
        Driver driver = new Driver(name, gender, age, vehicleDetails, new Location(x, y));
        driverService.addDriver(driver);
        System.out.println("Driver added: " + name);
    }

    @GetMapping("/find_ride")
    public String findRide(@RequestParam String userName, @RequestParam int srcX, @RequestParam int srcY,
                                 @RequestParam int destX, @RequestParam int destY) {
        System.out.println("User " + userName + " is requesting a ride from (" + srcX + "," + srcY + ") to (" + destX + "," + destY + ")");

        try {
            Location source = new Location(srcX, srcY);
            Location destination = new Location(destX, destY);
            List<Driver> availableDrivers = bookingService.findRide(source, destination);

            if (availableDrivers.isEmpty()) {
                return "No ride found";
            } else {
                return "Available drivers: " + availableDrivers.stream()
                        .map(Driver::toString)
                        .collect(Collectors.joining(", "));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while finding rides";
        }
    }

    @PostMapping("/choose_ride")
    public void chooseRide(@RequestParam String userName, @RequestParam String driverName) {
        bookingService.chooseRide(userName, driverName);
    }
}
