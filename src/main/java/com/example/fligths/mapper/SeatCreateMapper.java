package com.example.fligths.mapper;

import com.example.fligths.dto.request.SeatCreateDto;
import com.example.fligths.entity.Aircraft;
import com.example.fligths.entity.Seat;
import com.example.fligths.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SeatCreateMapper implements Mapper<SeatCreateDto, Seat> {

	private final AircraftRepository seatRepository;

	@Override
	public Seat map(SeatCreateDto object) {
		Seat seatDto = new Seat();
		copy(object, seatDto);
		return seatDto;
	}

	private void copy(SeatCreateDto object, Seat seatDto) {
		seatDto.setSeatNo(object.seatNo());
		seatDto.setAircraft(getAircraft(object.aircraftId()));
	}

	private Aircraft getAircraft(Integer aircraftId) {
		return Optional.ofNullable(aircraftId)
				.flatMap(seatRepository::findById)
				.orElse(null);
	}

	@Override
	public Seat map(SeatCreateDto fromObject, Seat toObject) {
		copy(fromObject, toObject);
		return toObject;
	}
}
