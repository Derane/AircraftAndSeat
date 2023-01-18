package com.example.fligths.controller;

import com.example.fligths.IntegrationTestBase;
import com.example.fligths.dto.SeatCreateDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeatControllerIT extends IntegrationTestBase {

	private final MockMvc mockMvc;

	private final ObjectMapper objectMapper;

	@Test
	void findAll() throws Exception {
		mockMvc.perform(get("/api/v1/seats").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();

	}

	@Test
	void create() throws Exception {
		SeatCreateDto seatCreateDto = new SeatCreateDto(1, "G23");
		mockMvc.perform(post("/api/v1/seats")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(seatCreateDto)))
				.andExpect(status().isCreated());
	}

	@Test
	public void findById() throws Exception {
		mockMvc.perform(get("/api/v1/seats/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.seatNo", Matchers.equalTo("A1")))
				.andReturn();
	}

	@Test
	public void findByIdAndSeatNo() throws Exception {
		mockMvc.perform(get("/api/v1/seats/1/A1"))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void findByIdAnAircraftId() throws Exception {
		mockMvc.perform(get("/api/v1/seats/1/aircraft").header("aircraftId", 1))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void update() throws Exception {
		SeatCreateDto seatCreateDto = new SeatCreateDto(2, "G23");
		mockMvc.perform(put("/api/v1/seats/update/1").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(seatCreateDto)))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void delete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/seats/delete/1"))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void deleteNonExistEntity() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/seats/delete/35"))
				.andExpect(status().is4xxClientError());
	}
}
