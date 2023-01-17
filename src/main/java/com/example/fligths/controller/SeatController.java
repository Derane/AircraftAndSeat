package com.example.fligths.controller;

import com.example.fligths.dto.PageResponse;
import com.example.fligths.dto.SeatCreateDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seats")
public class SeatController {

	private final SeatService seatService;

	@GetMapping
	public List<SeatDto> getAll() {
		return seatService.findAll();
	}

	@GetMapping
	public PageResponse<SeatDto> getAll(Pageable pageable) {
		Page<SeatDto> page = seatService.findAll(pageable);
		return PageResponse.of(page);
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

	@PostMapping("{id}/update")
	public SeatDto update(@PathVariable Integer id, @RequestBody SeatCreateDto createDto) {
		return seatService.update(id, createDto)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Integer id) {
		if (!seatService.delete(id)) {
			throw new ResponseStatusException(NOT_FOUND);
		}
		return null;
	}

}
