package com.gta.springboot.demospring.web;

import com.gta.springboot.demospring.business.domain.RoomReservation;
import com.gta.springboot.demospring.business.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/reservations")
public class RoomReservationWebController {

    @Autowired
    private final RoomReservationService roomReservationService = null;

    @GetMapping
    public String getReservations (@RequestParam(value = "date", required = false)String dateString, Model model) {
        Date reservationDate = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationsForDate(reservationDate);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }
}
