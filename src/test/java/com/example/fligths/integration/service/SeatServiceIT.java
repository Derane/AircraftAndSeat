package com.example.fligths.integration.service;

import com.example.fligths.IntegrationTestBase;
import com.example.fligths.dto.request.SeatCreateDto;
import com.example.fligths.dto.response.SeatDto;
import com.example.fligths.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeatServiceIT extends IntegrationTestBase {

	private static final Integer SEAT_1 = 1;
	private static final Integer SEAT_3 = 3;
	private static final Integer AIRCRAFT_1 = 1;
	private static final String MODEL_AIRCRAFT_1 = "Boeing 777-300";

	private final SeatService seatService;

	@Test
	void findAll() {
		List<SeatDto> result = seatService.findAll();
		assertThat(result).hasSize(12);
	}

	@Test
	void findById() {
		Optional<SeatDto> maybeSeat = seatService.findById(SEAT_1);
		assertTrue(maybeSeat.isPresent());
		maybeSeat.ifPresent(seat -> assertEquals("A1", seat.seatNo()));
	}

	@Test
	void findByIdAndSeatNo() {
		Optional<SeatDto> maybeSeat = seatService.findByIdAndSeatNo(SEAT_1, "A1");
		assertTrue(maybeSeat.isPresent());
		maybeSeat.ifPresent(seat -> assertEquals("A1", seat.seatNo()));
	}

	@Test
	void findByIdAndAircraftId() {
		Optional<SeatDto> maybeSeat = seatService.findByIdAndAircraftId(SEAT_1, 1);
		assertTrue(maybeSeat.isPresent());
		maybeSeat.ifPresent(seat -> {
			assertThat(seat.seatNo()).isEqualTo("A1");
			assertThat(seat.aircraftDto().model()).isEqualTo(MODEL_AIRCRAFT_1);
			assertThat(seat.aircraftDto().id()).isEqualTo(AIRCRAFT_1);
		});
	}

	@Test
	void create() {
		SeatCreateDto seatCreateDto = new SeatCreateDto(AIRCRAFT_1, "C100");
		SeatDto actualResult = seatService.create(seatCreateDto);
		assertThat(actualResult.seatNo()).isEqualTo(seatCreateDto.seatNo());
		assertThat(actualResult.aircraftDto().id()).isEqualTo(seatCreateDto.aircraftId());
	}

	@Test
	void update() {
		SeatCreateDto seatCreateDto = new SeatCreateDto(AIRCRAFT_1, "C100");
		Optional<SeatDto> maybeResult = seatService.update(1, seatCreateDto);
		assertThat(maybeResult.isPresent()).isEqualTo(TRUE);
		maybeResult.ifPresent(actualResult -> {
			assertThat(actualResult.seatNo()).isEqualTo(seatCreateDto.seatNo());
			assertThat(actualResult.aircraftDto().id()).isEqualTo(seatCreateDto.aircraftId());
		});
	}

	@Test
	void delete() {
		assertThat(seatService.delete(-2)).isEqualTo(FALSE);
		assertThat(seatService.delete(SEAT_3)).isEqualTo(TRUE);
	}

}
