package com.client.service.controller;

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

import com.client.service.entity.Client;
import com.client.service.service.ClientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Client>> listClient() {
		List<Client> client = clientService.getAll();
		if (client.isEmpty())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(client);
	}

	@GetMapping("/{idClient}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Client> getClient(@PathVariable("idClient") long idClient) {
		Client client = clientService.getClientById(idClient);
		if (client == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(client);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Client> saveClient(@RequestBody Client client) {
		try {
			Client newClient = clientService.save(client);
			return ResponseEntity.ok(newClient);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Error al realizar registro de Cliente", e);
		}
	}
}
