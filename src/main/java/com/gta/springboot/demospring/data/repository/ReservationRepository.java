package com.gta.springboot.demospring.data.repository;

import com.gta.springboot.demospring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    public Iterable<Reservation> getReservationByReservationDate(Date reservationDate);
}
