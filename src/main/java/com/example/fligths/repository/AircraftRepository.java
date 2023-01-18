package com.example.fligths.repository;

import com.example.fligths.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
}
