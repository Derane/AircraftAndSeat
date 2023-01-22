package com.example.fligths.repository;

import com.example.fligths.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

	Seat findByIdAndSeatNo(Integer id, String seatNo);

	Seat findByIdAndAircraftId(Integer id, Integer aircraft);
}
