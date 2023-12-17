package com.auca.onlineappaertmentreservistionbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

    @Data
    @Entity
    public class Administrator {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String names;
        private String email;
        private String phone;

        private String password;
}
