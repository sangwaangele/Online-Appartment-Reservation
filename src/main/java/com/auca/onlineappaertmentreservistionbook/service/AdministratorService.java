package com.auca.onlineappaertmentreservistionbook.service;

import com.auca.onlineappaertmentreservistionbook.model.Administrator;

import com.auca.onlineappaertmentreservistionbook.repostory.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Administrator getAdministratorById(Long id) {
        return administratorRepository.findById(id).orElse(null);
    }

    public Administrator saveAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }
    public Administrator loginAdministrator(String email, String password) {
        Administrator logedinAdministrator = administratorRepository.findByEmail(email,password);

        return logedinAdministrator;
    }
}
