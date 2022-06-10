package com.webshop.backend.services;

import com.webshop.backend.entity.Customer;
import com.webshop.backend.repositories.CustomerRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService  {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.saveAndFlush(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElseThrow();
    }
}
