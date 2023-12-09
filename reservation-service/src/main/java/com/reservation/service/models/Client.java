package com.reservation.service.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate localDate;
}
