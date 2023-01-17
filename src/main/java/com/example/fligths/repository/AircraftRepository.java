package com.example.fligths.repository;

import com.example.fligths.entity.Aircraft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Integer> {
	List<Aircraft> findAll();
}
