package com.example.fligths.exception;

public class SeatNotFoundException extends RuntimeException {

	public SeatNotFoundException() {
		super("Seat with entered ID do not exist!");
	}

}
