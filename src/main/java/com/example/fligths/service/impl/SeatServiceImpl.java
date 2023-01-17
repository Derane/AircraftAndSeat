package com.example.fligths.service.impl;

import com.example.fligths.dto.AircraftDto;
import com.example.fligths.dto.SeatCreateDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.exception.SeatNotFoundException;
import com.example.fligths.mapper.SeatCreateMapper;
import com.example.fligths.mapper.SeatDtoMapper;
import com.example.fligths.repository.SeatRepository;
import com.example.fligths.service.SeatService;
import jakarta.servlet.annotation.HttpConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

	private final SeatRepository seatRepository;
	private final SeatCreateMapper seatCreateMapper;
	private final SeatDtoMapper seatDtoMapper;
	@Override
	public List<SeatDto> getAll() {
		return seatRepository.findAll()
				.stream()
				.map(entity -> new SeatDto(
						new AircraftDto(entity.getAircraft().getId(), entity.getAircraft().getModel()), entity.getSeatNo()))
				.toList();
	}

	@Override
	public SeatDto findById(Integer id) {
		return seatRepository.findById(id)
				.map(entity -> new SeatDto(
						new AircraftDto(entity.getAircraft().getId(), entity.getAircraft().getModel()), entity.getSeatNo()))
				.orElseThrow(SeatNotFoundException::new);
	}

	@Transactional
	@Override
	public SeatDto create(SeatCreateDto seatCreateDto) {
		return Optional.of(seatCreateDto)
				.map(seatCreateMapper::map)
				.map(seatRepository::save)
				.map(seatDtoMapper::map)
				.orElseThrow();
	}

}
