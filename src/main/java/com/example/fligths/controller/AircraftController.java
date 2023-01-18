package com.example.fligths.controller;

import com.example.fligths.dto.AircraftDto;
import com.example.fligths.service.impl.AircraftServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

	private final AircraftServiceImpl aircraftService;

	@GetMapping
	public List<AircraftDto> getAll() {
		return aircraftService.findAll();
	}
}
