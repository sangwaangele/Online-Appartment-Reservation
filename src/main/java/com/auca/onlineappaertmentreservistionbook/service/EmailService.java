package com.auca.onlineappaertmentreservistionbook.service;

import com.auca.onlineappaertmentreservistionbook.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendConfirmationEmail(Customer customer) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(customer.getEmail());
        message.setSubject("Welcome to Apartment Reservation System - Account Confirmation");

        String emailText = "Hello " + customer.getNames() + ",\n\n" +
                "Welcome to Apartment Reservation System! Your account verification code is: " +
                customer.getConfirmationCode() + "\n\n" +
                "Thank you for choosing our services.\n\n" +
                "Best regards,\n" +
                "Apartment Reservation System Team";

        message.setText(emailText);
        javaMailSender.send(message);
    }
}
