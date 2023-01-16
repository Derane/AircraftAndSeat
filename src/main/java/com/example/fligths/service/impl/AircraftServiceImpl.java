package com.example.fligths.service.impl;

import com.example.fligths.controller.AircraftController;
import com.example.fligths.dto.AircraftDto;
import com.example.fligths.repository.impl.AircraftRepository;
import com.example.fligths.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

	private final AircraftRepository aircraftRepository;

	@Override
	public List<AircraftDto> getAll() {
		return aircraftRepository.findAll()
				.stream()
				.map(entity -> new AircraftDto(entity.getId(), entity.getModel()))
				.toList();
	}
}
