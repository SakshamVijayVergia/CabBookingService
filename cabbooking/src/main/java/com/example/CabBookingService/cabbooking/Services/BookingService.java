package com.example.CabBookingService.cabbooking.Services;

import com.example.CabBookingService.cabbooking.Models.Driver;
import com.example.CabBookingService.cabbooking.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    DriverService driverService;
    private static final double MAX_DISTANCE = 5.0;

    public List<Driver> findRide(Location source, Location destination) {
        List<Driver> availableDrivers = driverService.findAvailableDrivers(source, MAX_DISTANCE);

        return availableDrivers.stream()
                .sorted(Comparator.comparingDouble(driver -> driver.getCurrentLocation().distanceTo(source)))
                .collect(Collectors.toList());
    }

    public void chooseRide(String userName, String driverName) {
        driverService.setDriverAvailability(driverName, false);
        System.out.println("Ride booked successfully for " + userName + " with driver " + driverName);
    }
}