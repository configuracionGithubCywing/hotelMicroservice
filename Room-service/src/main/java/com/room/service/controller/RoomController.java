package com.room.service.controller;

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

import com.room.service.entity.Room;
import com.room.service.service.RoomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Room>> listClient() {
		List<Room> room = roomService.getAll();
		if (room.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(room);
	}

	@GetMapping("/{idRoom}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Room> getRoom(@PathVariable("idRoom") long idRoom) {
		Room room = roomService.getRoomById(idRoom);
		if (room == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(room);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
		try {
			Room newRoom = roomService.save(room);
			return ResponseEntity.ok(newRoom);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Error al realizar registro de Cuarto", e);
		}
	}
}
