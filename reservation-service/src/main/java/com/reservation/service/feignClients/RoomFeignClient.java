package com.reservation.service.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.reservation.service.models.Room;

@FeignClient(name = "room-service", url = "http://localhost:8092/room/")
public interface RoomFeignClient {

	@PostMapping("")
	public Room save(@RequestBody Room room, @RequestHeader("Authorization") String authorization);

	@GetMapping("")
	public List<Room> getAllRooms(@RequestHeader("Authorization") String authorization);

	@GetMapping("{idRoom}")
	public Room getRoom(@PathVariable("idRoom") long id, @RequestHeader("Authorization") String authorization);
}
