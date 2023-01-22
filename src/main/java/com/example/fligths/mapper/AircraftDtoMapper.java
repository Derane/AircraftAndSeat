package com.example.fligths.mapper;

import com.example.fligths.dto.response.AircraftDto;
import com.example.fligths.entity.Aircraft;
import org.springframework.stereotype.Component;

@Component
public class AircraftDtoMapper implements Mapper<Aircraft, AircraftDto> {
	@Override
	public AircraftDto map(Aircraft object) {
		return new AircraftDto(object.getId(), object.getModel());
	}
}
