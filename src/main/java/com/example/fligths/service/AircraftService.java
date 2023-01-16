package com.example.fligths.service;

import com.example.fligths.dto.AircraftDto;
import com.example.fligths.entity.Aircraft;

import java.util.List;

public interface AircraftService {
	List<AircraftDto> getAll();
}
