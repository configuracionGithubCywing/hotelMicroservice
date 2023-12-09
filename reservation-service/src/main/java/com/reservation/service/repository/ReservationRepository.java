package com.reservation.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reservation.service.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	List<Reservation> findByIdClient(long idClient);
	
	List<Reservation> findByIdRoom(long idRoom);

}
