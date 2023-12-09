package com.room.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.service.entity.Room;
import com.room.service.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	public List<Room> getAll(){
		return roomRepository.findAll();
	}
	public Room getRoomById(long id) {
		return roomRepository.findById(id).orElse(null);
	}
	public Room save(Room room) {
		Room newRoom =roomRepository.save(room);
		return newRoom;
	}
}
