package com.tradewise.customerservice.repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import com.tradewise.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);
    
}

