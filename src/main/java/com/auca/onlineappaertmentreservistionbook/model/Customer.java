package com.auca.onlineappaertmentreservistionbook.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String names;

    private String password;

    private String email;

    private String confirmationCode;

    private LocalDate dob; // Date of Birth

    private String gender;

    private String phone;

    private String address;
    private String status;


    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;
}
