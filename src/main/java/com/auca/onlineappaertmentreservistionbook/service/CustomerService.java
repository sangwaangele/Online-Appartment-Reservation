package com.auca.onlineappaertmentreservistionbook.service;

import com.auca.onlineappaertmentreservistionbook.model.ConfirmationCodeGenerator;
import com.auca.onlineappaertmentreservistionbook.model.Customer;
import com.auca.onlineappaertmentreservistionbook.repostory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final EmailService emailService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, EmailService emailService) {
        this.customerRepository = customerRepository;
        this.emailService = emailService;
    }

    public Customer saveCustomer(Customer customer) {
        // Set initial status to "Inactive"
        customer.setStatus("Inactive");

        // Generate a 6-digit confirmation code
        String confirmationCode = ConfirmationCodeGenerator.generateConfirmationCode();
        customer.setConfirmationCode(confirmationCode);

        // Save the customer with the updated information
        Customer savedCustomer = customerRepository.save(customer);

        // Send a confirmation email
        emailService.sendConfirmationEmail(savedCustomer);

        return savedCustomer;
    }
    public Customer saveCustomerAdmin(Customer customer) {
        // Set initial status to "Inactive"
        customer.setStatus("Active");

        // Generate a 6-digit confirmation code
        String confirmationCode = ConfirmationCodeGenerator.generateConfirmationCode();
        customer.setConfirmationCode(confirmationCode);

        // Save the customer with the updated information
        Customer savedCustomer = customerRepository.save(customer);

        // Send a confirmation email
        emailService.sendConfirmationEmail(savedCustomer);

        return savedCustomer;
    }

    public boolean confirmEmail(Long id, String confirmationCode) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        return optionalCustomer.map(customer -> {
            if (customer.getConfirmationCode().equals(confirmationCode)) {
                // Update status to "Active" if the confirmation code matches
                customer.setStatus("Active");
                customerRepository.save(customer);
                return true;
            }
            return false;
        }).orElse(false);
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }



    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    public Customer loginCustomer(String email, String password) {
        Customer logedInCustomer = customerRepository.loginCustomer(email,password);

       return logedInCustomer;
    }

}
