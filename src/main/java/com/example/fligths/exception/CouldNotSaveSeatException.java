package com.example.fligths.exception;

public class CouldNotSaveSeatException extends RuntimeException {

	public CouldNotSaveSeatException() {
		super("Seat with entered ID do not exist!");
	}

}
