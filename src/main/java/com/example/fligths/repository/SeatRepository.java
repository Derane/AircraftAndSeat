package com.example.fligths.repository;

import com.example.fligths.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

	List<Seat> findAll();
}
