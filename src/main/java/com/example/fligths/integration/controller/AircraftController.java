package com.example.fligths.integration.controller;

import com.example.fligths.dto.response.AircraftDto;
import com.example.fligths.integration.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/aircrafts")
@RequiredArgsConstructor
public class AircraftController {

	private final AircraftService aircraftService;

	@GetMapping
	public List<AircraftDto> getAll() {
		return aircraftService.findAll();
	}
}
