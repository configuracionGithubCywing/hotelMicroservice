package com.reservation.service.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.reservation.service.models.Client;

@FeignClient(name = "client-service", url = "http://localhost:8091/client/")
public interface  ClientFeignClient {
	
	 @PostMapping("")
	 public Client save(@RequestBody Client client,@RequestHeader("Authorization") String authorization);
	 
	 @GetMapping("")
	 public List<Client> getAllClients(@RequestHeader("Authorization") String authorization);
	 
	 @GetMapping("{idClient}")
	 public Client getClient(@PathVariable("idClient") long id,@RequestHeader("Authorization") String authorization);
}
