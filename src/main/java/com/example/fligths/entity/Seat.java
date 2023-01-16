package com.example.fligths.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aircraft_id")
	private Aircraft aircraft;

}
