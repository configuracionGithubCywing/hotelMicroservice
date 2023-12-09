package com.reservation.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.service.entity.Reservation;
import com.reservation.service.feignClients.ClientFeignClient;
import com.reservation.service.feignClients.RoomFeignClient;
import com.reservation.service.models.Client;
import com.reservation.service.models.Room;
import com.reservation.service.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ClientFeignClient clientFeignClient;
	
	@Autowired
	private RoomFeignClient roomFeignClient;
	
	public List<Reservation> getAll(){
		return reservationRepository.findAll();
	}
	public Reservation getReservationById(long idReservation) {
		return reservationRepository.findById(idReservation).orElse(null);
	}
	public Reservation save(Reservation reservation) {
		Reservation newReservation =reservationRepository.save(reservation);
		return newReservation;
	}
	public List<Reservation> getReservationByIdClient(long idClient){
		return reservationRepository.findByIdClient(idClient);
	}
	public List<Reservation> getReservationByIdRoom(long idRoom){
		return reservationRepository.findByIdRoom(idRoom);
	}
	public Client saveClient(Client client) {
		Client newClient = clientFeignClient.save(client, "Basic YWRtaW46YWRtaW4=");
		return newClient;
	}
	
	public Client findClient(long idClient) {
		Client newClient = clientFeignClient.getClient(idClient, "Basic YWRtaW46YWRtaW4=");
		return newClient;
	} 
	
	public List<Client> getAllClients(){
		List<Client> clients = clientFeignClient.getAllClients("Basic YWRtaW46YWRtaW4=");
		return clients;
	}
	public Room saveRoom(Room room) {
		Room newRoom = roomFeignClient.save(room, "Basic YWRtaW46YWRtaW4=");
		return newRoom;
	}
	
	public Room findRoom(long idRoom) {
		Room newRoom = roomFeignClient.getRoom(idRoom, "Basic YWRtaW46YWRtaW4=");
		return newRoom;
	} 
	
	public List<Room> getAllRooms(){
		List<Room> rooms = roomFeignClient.getAllRooms("Basic YWRtaW46YWRtaW4=");
		return rooms;
	}
	
}
