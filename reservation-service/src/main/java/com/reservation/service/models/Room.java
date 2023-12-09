package com.reservation.service.models;

import java.math.BigDecimal;
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
public class Room {
	private String code;
	private String type;
	private String description;
	private int capacity;
	private BigDecimal price;
}
