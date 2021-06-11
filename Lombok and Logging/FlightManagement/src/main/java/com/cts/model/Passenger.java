package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private boolean vip;
	
}
