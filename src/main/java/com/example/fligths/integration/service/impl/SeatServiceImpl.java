package com.example.fligths.integration.service.impl;

import com.example.fligths.dto.request.SeatCreateDto;
import com.example.fligths.dto.response.SeatDto;
import com.example.fligths.exception.CouldNotSaveSeatException;
import com.example.fligths.mapper.SeatCreateMapper;
import com.example.fligths.mapper.SeatDtoMapper;
import com.example.fligths.repository.SeatRepository;
import com.example.fligths.integration.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

	private final SeatRepository seatRepository;

	private final SeatCreateMapper seatCreateMapper;
	private final SeatDtoMapper seatDtoMapper;

	@Override
	public Page<SeatDto> findAll(Pageable pageable) {
		return seatRepository.findAll(pageable)
				.map(seatDtoMapper::map);
	}

	@Override
	public List<SeatDto> findAll() {
		return seatRepository.findAll()
				.stream()
				.map(seatDtoMapper::map)
				.toList();
	}

	@Override
	public Optional<SeatDto> findByIdAndSeatNo(Integer id, String seatNo) {
		return ofNullable(seatRepository.findByIdAndSeatNo(id, seatNo)).map(seatDtoMapper::map);
	}

	@Override
	public Optional<SeatDto> findByIdAndAircraftId(Integer id, Integer aircraftId) {
		return ofNullable(seatRepository.findByIdAndAircraftId(id, aircraftId)).map(seatDtoMapper::map);
	}

	@Override
	public Optional<SeatDto> findById(Integer id) {
		return seatRepository.findById(id)
				.map(seatDtoMapper::map);
	}

	@Transactional
	@Override
	public SeatDto create(SeatCreateDto seatCreateDto) {
		return of(seatCreateDto)
				.map(seatCreateMapper::map)
				.map(seatRepository::saveAndFlush)
				.map(seatDtoMapper::map)
				.orElseThrow(CouldNotSaveSeatException::new);
	}

	@Transactional
	@Override
	public Optional<SeatDto> update(Integer id, SeatCreateDto seatCreateDto) {
		return seatRepository.findById(id)
				.map(entity -> seatCreateMapper.map(seatCreateDto, entity))
				.map(seatRepository::save)
				.map(seatDtoMapper::map);
	}

	@Transactional
	@Override
	public boolean delete(Integer id) {
		return seatRepository.findById(id)
				.map(entity -> {
					seatRepository.delete(entity);
					return true;
				}).orElse(false);
	}

}
