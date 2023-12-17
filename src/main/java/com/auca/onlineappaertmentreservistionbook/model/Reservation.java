package com.auca.onlineappaertmentreservistionbook.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Apartment apartment;

}
