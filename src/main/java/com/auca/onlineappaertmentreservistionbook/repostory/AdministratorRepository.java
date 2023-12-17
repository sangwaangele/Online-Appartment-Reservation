package com.auca.onlineappaertmentreservistionbook.repostory;

import com.auca.onlineappaertmentreservistionbook.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {
    @Query("from Administrator where email=:email and password=:password")
    Administrator  findByEmail(String email,String password);
}
