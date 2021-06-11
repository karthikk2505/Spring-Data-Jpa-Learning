package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.exception.InvalidFlightOperation;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class FlightManagementApplication {
	public static void main(String[] args) throws InvalidFlightOperation {
		
		SpringApplication.run(FlightManagementApplication.class, args);
		log.info("Logging the FlightManagementApplication");
		throw new InvalidFlightOperation("Invalid");
	}

}
