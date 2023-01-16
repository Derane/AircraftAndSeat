package com.example.fligths.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Aircraft {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String model;


	@OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY)
	private List<Seat> seats;

	public void addProduct(Seat seat) {
		seats.add(seat);
		seat.setAircraft(this);
	}

	public void removeProduct(Seat seat) {
		seats.remove(seat);
		seat.setAircraft(null);
	}
}
