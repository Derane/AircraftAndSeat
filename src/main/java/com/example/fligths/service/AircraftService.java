package com.example.fligths.service;

import com.example.fligths.dto.response.AircraftDto;

import java.util.List;

public interface AircraftService {
	List<AircraftDto> findAll();
}
