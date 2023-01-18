package com.example.fligths.service;

import com.example.fligths.IntegrationTestBase;
import com.example.fligths.dto.SeatDto;
import com.example.fligths.service.impl.SeatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeatServiceIT extends IntegrationTestBase {

	private static final Integer USER_1 = 1;
	private static final Integer COMPANY_1 = 1;

	private final SeatServiceImpl seatService;

	@Test
	void findAll() {
		List<SeatDto> result = seatService.findAll();
		assertThat(result).hasSize(12);
	}

	@Test
	void findById() {
		Optional<SeatDto> maybeSeat = seatService.findById(USER_1);
		assertTrue(maybeSeat.isPresent());
		maybeSeat.ifPresent(seat -> assertEquals("A1", seat.seatNo()));
	}


}
