package com.tradewise.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tradewise.admin.dto.CustomerDTO;
import com.tradewise.admin.dto.StockDTO;
import com.tradewise.admin.service.AdminService;
//import com.tradewise.customerservice.model.Customer;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // End point to add a stock
    @PostMapping("/addStock")
    public ResponseEntity<StockDTO> addStock(@RequestBody StockDTO stock) {
        StockDTO addedStock = adminService.addStock(stock);
        return ResponseEntity.ok(addedStock);
    }

    // End point to get all stocks
    @GetMapping("/allStocks")
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = adminService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }

    // End point to get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = adminService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    
    
}