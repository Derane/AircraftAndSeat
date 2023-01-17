package com.example.fligths.service;

import com.example.fligths.dto.SeatCreateDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.entity.Seat;

import java.util.List;

public interface SeatService {
	List<SeatDto> getAll();

	SeatDto findById(Integer id);

	SeatDto create(SeatCreateDto seatCreateDto);

}
