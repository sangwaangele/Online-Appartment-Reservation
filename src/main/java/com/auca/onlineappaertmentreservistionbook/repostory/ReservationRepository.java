package com.auca.onlineappaertmentreservistionbook.repostory;

import com.auca.onlineappaertmentreservistionbook.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("from Reservation where customer.id =:id")
   List<Reservation> findByCustomer(Long id);
}
