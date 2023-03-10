package com.example.fligths.service;

import com.example.fligths.dto.request.SeatCreateDto;
import com.example.fligths.dto.response.SeatDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SeatService {

	Page<SeatDto> findAll(Pageable pageable);

	List<SeatDto> findAll();

	Optional<SeatDto> findById(Integer id);

	Optional<SeatDto> findByIdAndSeatNo(Integer id, String seatNo);

	Optional<SeatDto> findByIdAndAircraftId(Integer id, Integer aircraftId);

	SeatDto create(SeatCreateDto seatCreateDto);

	Optional<SeatDto> update(Integer id, SeatCreateDto seatCreateDto);

	boolean delete(Integer id);
}
