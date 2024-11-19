package com.tradewise.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewise.admin.client.CustomerServiceClient;
import com.tradewise.admin.client.StockServiceClient;
import com.tradewise.admin.dto.CustomerDTO;
import com.tradewise.admin.dto.StockDTO;

@Service
public class AdminService {

    @Autowired
    private StockServiceClient stockServiceClient;

    @Autowired
    private CustomerServiceClient customerServiceClient;

    // Method to add a stock by calling StockServiceClient
    public StockDTO addStock(StockDTO stock) {
        return stockServiceClient.addStock(stock);
    }

    // Method to get all stocks by calling StockServiceClient
    public List<StockDTO> getAllStocks() {
        return stockServiceClient.getAllStocks();
    }

    // Method to get all customers by calling CustomerServiceClient
    public List<CustomerDTO> getAllCustomers() {
        return customerServiceClient.getAllCustomers();
    }
}
