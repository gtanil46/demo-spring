package com.gta.springboot.demospring.business.service;

import com.gta.springboot.demospring.business.domain.RoomReservation;
import com.gta.springboot.demospring.data.entity.Guest;
import com.gta.springboot.demospring.data.entity.Reservation;
import com.gta.springboot.demospring.data.entity.Room;
import com.gta.springboot.demospring.data.repository.GuestRepository;
import com.gta.springboot.demospring.data.repository.ReservationRepository;
import com.gta.springboot.demospring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomReservationService {

    @Autowired
    private final RoomRepository roomRepository = null;
    @Autowired
    private final GuestRepository guestRepository = null;
    @Autowired
    private final ReservationRepository reservationRepository = null;


    public List<RoomReservation> getRoomReservationsForDate(Date reservationDate) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.getReservationByReservationDate(new java.sql.Date(reservationDate.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setReservationDate(reservationDate);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (long roomId: roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }
}
