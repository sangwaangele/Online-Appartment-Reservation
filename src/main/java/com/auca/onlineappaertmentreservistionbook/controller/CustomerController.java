package com.auca.onlineappaertmentreservistionbook.controller;

import com.auca.onlineappaertmentreservistionbook.model.Customer;
import com.auca.onlineappaertmentreservistionbook.model.CustomerLoginForm;
import com.auca.onlineappaertmentreservistionbook.service.CustomerService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/confirm/" + customer.getId();
    }

    @GetMapping("/confirm/{id}")
    public String showConfirmForm(@PathVariable Long id, Model model) {
        model.addAttribute("customerId", id);
        return "confirm";
    }

    @PostMapping("/confirm")
    public String processConfirmation(@RequestParam Long customerId, @RequestParam String confirmationCode) {
        if (customerService.confirmEmail(customerId, confirmationCode)) {
            return "redirect:/login?confirmed=true";
        } else {
            return "redirect:/login?confirmed=false";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(CustomerLoginForm customerLoginForm, Model model, HttpSession session) {
       Customer customer = customerService.loginCustomer(customerLoginForm.getEmail(), customerLoginForm.getPassword());

        if (customer != null) {
            // Successful login
            session.setAttribute("authenticatedCustomer", customer);
            model.addAttribute("customer", customer);
            return "redirect:/customer";
        }  else {

            model.addAttribute("loginError", true);
            model.addAttribute("errorMessage", "Incorrect email or password");
            return "login";
        }


    }
    @GetMapping("/edit/{id}")
    private String getCustomerForm(@PathVariable Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customerForm";
    }
    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer) {
        customerService.saveCustomerAdmin(customer);
        return "redirect:/adminCustomer";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@RequestParam Long id){
        customerService.deleteCustomer(id);

        return "redirect:/adminCustomer";
    }

}
