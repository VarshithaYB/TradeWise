package com.tradewise.customerservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewise.customerservice.model.Customer;
import com.tradewise.customerservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get customer by ID
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by name
    public Optional<Customer> getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    // Add or update customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete customer
    public boolean deleteCustomer(String id) {
     
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return true;  // Deletion successful
        } else {
            return false;  // Customer not found
        }
    }
}

