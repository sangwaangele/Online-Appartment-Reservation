package com.auca.onlineappaertmentreservistionbook.repostory;

import com.auca.onlineappaertmentreservistionbook.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("from Customer where email=:email and password=:password and status='Active'")
    Customer loginCustomer(String email,String password);
}
