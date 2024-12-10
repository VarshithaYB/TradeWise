package com.tradewise.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tradewise.customerservice.client.StockClient;
import com.tradewise.customerservice.exceptionhandler.BadRequestException;
import com.tradewise.customerservice.exceptionhandler.CustomerNotFoundException;
import com.tradewise.customerservice.model.Customer;
import com.tradewise.customerservice.model.Stock;
import com.tradewise.customerservice.service.CustomerService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private StockClient stockClient;

    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }



    // Create or update customer
    @PostMapping
    public ResponseEntity<Customer> createOrUpdateCustomer(@RequestBody Customer customer) {
        // Check if customer data is valid (you can define your own validation)
        if (customer.getName() == null || customer.getEmail() == null) {
            throw new BadRequestException("Customer name and email are required.");
        }
        
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        boolean deleted = customerService.deleteCustomer(id);
        if (!deleted) {
            throw new CustomerNotFoundException("Customer not found for ID: " + id);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    



    
//    @GetMapping("/stocks/by-email")
//    public ResponseEntity<List<Stock>> getStocksByEmail(@RequestParam String email) {
//        // Validate customer existence by email
//        Optional<Customer> customer = customerService.getCustomerByEmail(email);
//        if (customer.isEmpty()) {
//            throw new CustomerNotFoundException("Customer not found with email: " + email);
//        }
//
//        // Call Stock Service to get stocks by email
//        List<Stock> stocks = stockClient.getStocksByEmail(email);
//        return new ResponseEntity<>(stocks, HttpStatus.OK);
//    }


    @GetMapping("/{email}/stocks")
    public ResponseEntity<List<Stock>> getCustomerStocks(@PathVariable String email) {
        List<Stock> stocks = stockClient.getStocksByEmail(email);
        return ResponseEntity.ok(stocks);
    }



}
