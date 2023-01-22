package com.example.fligths.mapper;

import com.example.fligths.dto.response.AircraftDto;
import com.example.fligths.dto.response.SeatDto;
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
				.map(aircraftDtoMapper::map)
				.orElse(null);

		return new SeatDto(
				object.getId(),
				aircraftDto,
				object.getSeatNo()
		);
	}
}
