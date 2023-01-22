package com.example.fligths.integration.service;

import com.example.fligths.dto.response.AircraftDto;

import java.util.List;

public interface AircraftService {
	List<AircraftDto> findAll();
}
