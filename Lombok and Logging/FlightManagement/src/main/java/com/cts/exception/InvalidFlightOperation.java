package com.cts.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InvalidFlightOperation extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidFlightOperation()
	{
		
	}
	public InvalidFlightOperation(String message)
	{
		log.error("Invalid Flight Operation : {} :: Cause: {}",message,getCause());
	}
}
