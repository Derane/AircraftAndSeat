package com.example.fligths.controller;

import com.example.fligths.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/seats")
public class SeatController {

	private final SeatService seatService;


}
