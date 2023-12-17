package com.auca.onlineappaertmentreservistionbook.controller;

import com.auca.onlineappaertmentreservistionbook.model.Customer;
import com.auca.onlineappaertmentreservistionbook.model.Reservation;
import com.auca.onlineappaertmentreservistionbook.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reerReservationService;
    @PostMapping("/saveReservation")
    public String saveReservation(Model model, Reservation reservation){
        Reservation reservation1=reerReservationService.saveReservation(reservation);
        return "redirect:/adminReservation";

    }

    @PostMapping("/saveReservationCustomer")
    public String saveReservationCustomer(Model model, Reservation reservation){
        reerReservationService.saveReservation(reservation);
        return "redirect:/customerReservation";

    }

}
