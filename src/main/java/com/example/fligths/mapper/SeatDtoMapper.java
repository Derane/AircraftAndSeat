package com.example.fligths.mapper;

import com.example.fligths.dto.AircraftDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.entity.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SeatDtoMapper implements Mapper<Seat, SeatDto> {

	private final AircraftDtoMapper aircraftDtoMapper;

	@Override
	public SeatDto map(Seat object) {

		AircraftDto aircraftDto = Optional.ofNullable(object.getAircraft())
				.map(entity -> new AircraftDto(entity.getId(), entity.getModel()))
				.orElse(null);

		return new SeatDto(
				aircraftDto,
				object.getSeatNo()
		);
	}
}
