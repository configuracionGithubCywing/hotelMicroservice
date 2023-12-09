package com.client.service.models;

import java.math.BigDecimal;
import java.time.LocalDate;
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
public class Reservation {
	private LocalDate starDate;
	private LocalDate starEnd;
	private BigDecimal amount;
	private String state;
	private long idClient;
	private long idRoom;
}
