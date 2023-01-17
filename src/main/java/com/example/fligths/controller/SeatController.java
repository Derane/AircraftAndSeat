package com.example.fligths.controller;

import com.example.fligths.dto.SeatCreateDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seats")
public class SeatController {

	private final SeatService seatService;

	@GetMapping
	public List<SeatDto> getAll() {
		return seatService.getAll();
	}

	@GetMapping("/{id}")
	public SeatDto findById(@PathVariable Integer id) {
		return seatService.findById(id);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public SeatDto create(@RequestBody SeatCreateDto createDto) {
		return seatService.create(createDto);

	}
}
