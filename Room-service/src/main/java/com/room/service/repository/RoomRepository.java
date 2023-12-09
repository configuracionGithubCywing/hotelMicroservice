package com.room.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.room.service.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{
	
}
