package com.example.fligths.integration.controller;

import com.example.fligths.dto.response.PageResponse;
import com.example.fligths.dto.request.SeatCreateDto;
import com.example.fligths.dto.response.SeatDto;
import com.example.fligths.integration.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/seats")
public class SeatController {

	private final SeatService seatService;

	@GetMapping
	public PageResponse<SeatDto> getAll(Pageable pageable) {
		Page<SeatDto> page = seatService.findAll(pageable);
		return PageResponse.of(page);
	}

	@GetMapping("/{id}")
	public SeatDto findById(@PathVariable Integer id) {
		return seatService.findById(id)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@GetMapping("/{id}/{seatNo}")
	public SeatDto findByIdAndSeatNo(@PathVariable Integer id, @PathVariable String seatNo) {
		return seatService.findByIdAndSeatNo(id, seatNo)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@GetMapping("/{id}/aircraft")
	public SeatDto findByIdAndAircraftId(@PathVariable Integer id, @RequestHeader Integer aircraftId) {
		return seatService.findByIdAndAircraftId(id, aircraftId)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public SeatDto create(@RequestBody SeatCreateDto createDto) {
		return seatService.create(createDto);
	}

	@PutMapping("/update/{id}")
	public SeatDto update(@PathVariable Integer id, @RequestBody @Valid SeatCreateDto createDto) {
		return seatService.update(id, createDto)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		if (!seatService.delete(id)) {
			throw new ResponseStatusException(NOT_FOUND);
		}
	}

}
