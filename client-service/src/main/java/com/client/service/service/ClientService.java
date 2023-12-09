package com.client.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.client.service.entity.Client;
import com.client.service.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	public Client getClientById(long idClient) {
		return clientRepository.findById(idClient).orElse(null);
	}
	public Client save(Client client) {
		Client newClient =clientRepository.save(client);
		return newClient;
	}
}
