package com.reservation.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.service.entity.Reservation;
import com.reservation.service.models.Client;
import com.reservation.service.models.Room;
import com.reservation.service.service.ReservationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Reservation>> listReservation() {
		List<Reservation> reservation = reservationService.getAll();
		if (reservation.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(reservation);
	}

	@GetMapping("/{idReservation}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Reservation> getReservation(@PathVariable("idReservation") long idReservation) {
		Reservation reservation = reservationService.getReservationById(idReservation);
		if (reservation == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(reservation);
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
		try {
			Client client = reservationService.findClient(reservation.getIdClient());
			if (client == null)
				return (ResponseEntity<Reservation>) ResponseEntity.badRequest();
							
			Room room = reservationService.findRoom(reservation.getIdRoom());
			if (room == null)
				return (ResponseEntity<Reservation>) ResponseEntity.badRequest();
						
			Reservation newReservation = reservationService.save(reservation);
			return ResponseEntity.ok(newReservation);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Error al realizar registro de Reservación", e);
		}
	}

	@GetMapping("/client/{idClient}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Reservation>> getByClient(@PathVariable("idClient") long idClient) {
		List<Reservation> reservations = reservationService.getReservationByIdClient(idClient);
		if (reservations == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(reservations);
	}

	@GetMapping("/room/{idRoom}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Reservation>> getByRoom(@PathVariable("idRoom") long idRoom) {
		List<Reservation> reservations = reservationService.getReservationByIdRoom(idRoom);
		if (reservations == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(reservations);
	}
}
