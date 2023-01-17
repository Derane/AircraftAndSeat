package com.example.fligths.mapper;

import com.example.fligths.dto.SeatCreateDto;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.entity.Aircraft;
import com.example.fligths.entity.Seat;
import com.example.fligths.repository.AircraftRepository;
import com.example.fligths.repository.SeatRepository;
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
		seatDto.setSeatNo(object.SeatNo());
		seatDto.setAircraft(getAircraft(object.aircraftId()));
		return seatDto;
	}

	private Aircraft getAircraft(Integer aircraftId){
		return Optional.ofNullable(aircraftId)
				.flatMap(seatRepository::findById)
				.orElse(null);
	}
}
