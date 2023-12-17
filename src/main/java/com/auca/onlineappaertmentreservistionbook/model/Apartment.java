package com.auca.onlineappaertmentreservistionbook.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    private String photoPath; // Store the path to the photo
    private String numberOfRooms; // Number of rooms
    private String status;
    private double amount;

    @OneToMany(mappedBy = "apartment")
    private List<Reservation> reservations;

}
