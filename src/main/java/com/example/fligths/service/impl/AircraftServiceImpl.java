package com.example.fligths.service.impl;

import com.example.fligths.dto.response.AircraftDto;
import com.example.fligths.mapper.AircraftDtoMapper;
import com.example.fligths.repository.AircraftRepository;
import com.example.fligths.service.AircraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

	private final AircraftRepository aircraftRepository;

	private final AircraftDtoMapper aircraftDtoMapper;

	@Override
	public List<AircraftDto> findAll() {
		return aircraftRepository.findAll()
				.stream()
				.map(aircraftDtoMapper::map)
				.toList();
	}
}
