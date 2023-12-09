package com.reservation.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reservation.service.models.Room;
import com.reservation.service.service.ReservationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Room> saveRoom(@RequestBody Room room ){
		Room newRoom = reservationService.saveRoom(room);
		return ResponseEntity.ok(newRoom);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Room>> listClient() {
		List<Room> room = reservationService.getAllRooms();
		if (room.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(room);
	}
	
	@GetMapping("/{idRoom}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Room> getRoom(@PathVariable("idRoom") long idRoom) {
		Room room = reservationService.findRoom(idRoom);
		if (room == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(room);
	}
}
