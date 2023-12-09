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

import com.reservation.service.models.Client;
import com.reservation.service.service.ReservationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Client> saveClient(@RequestBody Client client ){
		Client newClient = reservationService.saveClient(client);
		return ResponseEntity.ok(newClient);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Client>> listClient() {
		List<Client> client = reservationService.getAllClients();
		if (client.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(client);
	}
	
	@GetMapping("/{idClient}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Client> getClient(@PathVariable("idClient") long idClient) {
		Client client = reservationService.findClient(idClient);
		if (client == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(client);
	}
}
