package com.client.service.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.client.service.models.Reservation;

@FeignClient(name = "reservation-service", url = "http://localhost:8093")
public interface  ReservationFeignClient {
	
	 @GetMapping("/reservation/client/{idClient}")
	 List<Reservation> getReservationsByClientId(@PathVariable("idClient") long id,@RequestHeader("Authorization") String authorization);
}
