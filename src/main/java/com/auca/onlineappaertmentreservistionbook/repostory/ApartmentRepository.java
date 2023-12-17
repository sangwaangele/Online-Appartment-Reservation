package com.auca.onlineappaertmentreservistionbook.repostory;

import com.auca.onlineappaertmentreservistionbook.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
}
