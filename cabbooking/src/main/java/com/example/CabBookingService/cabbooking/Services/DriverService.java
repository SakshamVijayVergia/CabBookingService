package com.example.CabBookingService.cabbooking.Services;
import com.example.CabBookingService.cabbooking.Models.Driver;
import com.example.CabBookingService.cabbooking.Models.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    private final List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> findAvailableDrivers(Location source, double maxDistance) {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.isAvailable() && driver.getCurrentLocation().distanceTo(source) <= maxDistance) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    public void setDriverAvailability(String driverName, boolean available) {
        for (Driver driver : drivers) {
            if (driver.getName().equalsIgnoreCase(driverName)) {
                driver.setAvailable(available);
                break;
            }
        }
    }
}