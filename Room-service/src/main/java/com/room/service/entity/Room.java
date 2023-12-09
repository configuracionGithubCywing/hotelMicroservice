package com.room.service.entity;

import java.math.BigDecimal;
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
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRoom;
	@Column(nullable = false, unique = true)
	private String code;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int capacity;
	@Column(nullable = false)
	private BigDecimal price;

}
