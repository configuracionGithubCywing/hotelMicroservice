package com.client.service.entity;

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

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	private LocalDate localDate;
}
