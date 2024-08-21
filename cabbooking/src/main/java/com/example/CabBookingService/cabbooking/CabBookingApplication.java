package com.example.CabBookingService.cabbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class CabBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}
}
