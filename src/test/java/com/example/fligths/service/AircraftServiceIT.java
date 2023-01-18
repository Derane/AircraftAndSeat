package com.example.fligths.service;

import com.example.fligths.IntegrationTestBase;
import com.example.fligths.dto.AircraftDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AircraftServiceIT extends IntegrationTestBase {


	private final AircraftService aircraftService;

	@Test
	void findAll() {
		List<AircraftDto> result = aircraftService.findAll();
		assertThat(result).hasSize(4);
	}

}
