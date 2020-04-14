package com.gta.springboot.demospring;

import com.gta.springboot.demospring.data.entity.Guest;
import com.gta.springboot.demospring.data.entity.Reservation;
import com.gta.springboot.demospring.data.entity.Room;
import com.gta.springboot.demospring.data.repository.GuestRepository;
import com.gta.springboot.demospring.data.repository.ReservationRepository;
import com.gta.springboot.demospring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
