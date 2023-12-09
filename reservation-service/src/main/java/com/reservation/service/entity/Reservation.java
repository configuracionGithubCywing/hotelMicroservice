package com.reservation.service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idReservation;
	@Column(nullable = false)
	private LocalDate starDate;
	@Column(nullable = false)
	private LocalDate starEnd;
	@Column(nullable = false)
	private BigDecimal amount;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private long idClient;
	@Column(nullable = false)
	private long idRoom;
}
