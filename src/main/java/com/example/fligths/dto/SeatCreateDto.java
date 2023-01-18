package com.example.fligths.dto;

import javax.validation.constraints.NotBlank;

public record SeatCreateDto(Integer aircraftId, String seatNo) {
}