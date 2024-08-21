package com.example.CabBookingService.cabbooking;
import com.example.CabBookingService.cabbooking.Controllers.BookingController;
import com.example.CabBookingService.cabbooking.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CabBookingApplicationRunner implements CommandLineRunner {

    @Autowired
    BookingController bookingController;

    @Override
    public void run(String... args) throws Exception {
        // Onboard Users
        bookingController.addUser(new User("Abhishek", "M", 23));
        bookingController.addUser(new User("Rahul", "M", 29));
        bookingController.addUser(new User("Nandini", "F", 22));

        // Onboard Drivers
        bookingController.addDriver("Driver1", "M", 22, "Swift, KA-01-12345", 10, 3);
        bookingController.addDriver("Driver2", "M", 29, "Swift, KA-01-12345", 10, 2);
        bookingController.addDriver("Driver3", "M", 24, "Swift, KA-01-12345", 5, 3);

        // User trying to get a ride
        System.out.println(bookingController.findRide("Abhishek", 0, 0, 20, 1));
        System.out.println(bookingController.findRide("Rahul", 10, 0, 15, 3));
        // Choosing a ride
        bookingController.chooseRide("Rahul", "Driver2");
        System.out.println(bookingController.findRide("Nandini", 10, 3, 20, 4));

    }
}
