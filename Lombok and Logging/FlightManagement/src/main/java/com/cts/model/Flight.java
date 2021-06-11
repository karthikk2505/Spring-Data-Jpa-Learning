package com.cts.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter
	private String flightType;
	
	List<Passenger> passengers;
	
	public boolean addPassenger(Passenger passenger) {
		log.info("Adding passenger to Flight: {}",passenger);
		return passengers.add(passenger);
	}
	public boolean removePassenger(Passenger passenger) {
		log.info("Removing passenger to Flight: {}",passenger);
		return passengers.remove(passenger);
	}
	
}
