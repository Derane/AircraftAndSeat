package com.example.fligths.repository;

import com.example.fligths.entity.Aircraft;
import com.example.fligths.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

	List<Seat> findAll();
}
