package com.example.fligths.service;

import com.example.fligths.IntegrationTestBase;
import com.example.fligths.dto.SeatDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class SeatServiceIT extends IntegrationTestBase {

	private static final Long USER_1 = 1L;
	private static final Integer COMPANY_1 = 1;

	private final SeatService userService;

	@Test
	void findAll() {
		List<SeatDto> result = userService.findAll();
		assertThat(result).hasSize(32);
	}


}
