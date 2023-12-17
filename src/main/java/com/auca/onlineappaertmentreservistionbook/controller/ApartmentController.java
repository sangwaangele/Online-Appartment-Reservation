package com.auca.onlineappaertmentreservistionbook.controller;

import com.auca.onlineappaertmentreservistionbook.model.Administrator;
import com.auca.onlineappaertmentreservistionbook.model.Apartment;
import com.auca.onlineappaertmentreservistionbook.model.Customer;
import com.auca.onlineappaertmentreservistionbook.service.ApartmentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApartmentController {
   @Autowired
  private  ApartmentService apartmentService;

   @PostMapping("/saveApartment")
   public String saveCustomer(Apartment apartment) {
      apartmentService.saveApartment(apartment);
      return "redirect:/adminApartment";
   }
   @GetMapping("/apartmentForm")
   public String getCustomerForm(Model model, HttpSession session){
      Administrator loggedInAdministrator=(Administrator) session.getAttribute("loggedInAdministrator");
      if(loggedInAdministrator!=null){
         model.addAttribute("loggedInAdministrator",loggedInAdministrator);
         model.addAttribute("apartment", new Apartment());

         return "apartmentForm";

      }else {
         return "redirect:/adminLogin";
      }
   }
    @GetMapping("/deleteApartment/{id}")
    public String deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
        return "redirect:/adminApartment";
    }
    @GetMapping("/editApartment/{id}")
    private String getCustomerForm(@PathVariable Long id, Model model){
        Apartment apartment = apartmentService.getApartmentById(id);
        model.addAttribute("apartment", apartment);
        return "apartmentForm";
    }

   }
