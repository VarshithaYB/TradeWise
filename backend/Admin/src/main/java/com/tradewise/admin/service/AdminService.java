package com.tradewise.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewise.admin.client.CustomerServiceClient;
import com.tradewise.admin.client.StockServiceClient;
//import com.tradewise.admin.dto.CustomerDTO;
import com.tradewise.admin.dto.CustomerWithStocksDTO;
//import com.tradewise.admin.dto.StockDTO;


@Service
public class AdminService {

    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Autowired
    private StockServiceClient stockServiceClient; // Assume you have another Feign client for Stock

//    public List<CustomerWithStocksDTO> getAllCustomerWithStocks() {
//        // Fetch all customers
//        List<CustomerDTO> customers = customerServiceClient.getAllCustomers();
//
//        // Fetch all stocks (assuming stocks are globally available)
//        List<StockDTO> stocks = stockServiceClient.getAllStocks(); 
//
//        // Combine the data into CustomerWithStocksDTO
//        List<CustomerWithStocksDTO> result = new ArrayList<>();
//        for (CustomerDTO customer : customers) {
//            for (StockDTO stock : stocks) {
//                if (stock.getCompany().equalsIgnoreCase(customer.getName())) { 
//                    // Assuming customer name matches stock's company (adjust if needed)
//                    CustomerWithStocksDTO combined = new CustomerWithStocksDTO(
//                        customer.getName(),
//                        customer.getEmail(),
//                        customer.getPassword(),
//                        stock.getCompany(),
//                        stock.getSymbol(),
//                        stock.getCurrentPrice(),
//                        stock.getInitialPrice(),
//                        stock.getQuantity()
//                    );
//                    result.add(combined);
//                }
//            }
//        }
//
//        return result;
//    }
    
  // Method to add a stock by calling StockServiceClient
//  public StockDTO addStock(StockDTO stock) {
//      return stockServiceClient.addStock(stock);
//  }
//
//  // Method to get all stocks by calling StockServiceClient
//  public List<StockDTO> getAllStocks() {
//      return stockServiceClient.getAllStocks();
//  }
//
//  // Method to get all customers by calling CustomerServiceClient
//  public List<CustomerDTO> getAllCustomers() {
//      return customerServiceClient.getAllCustomers();
//  }
    
    // Method to fetch customers with their stocks
    public List<CustomerWithStocksDTO> getAllCustomerWithStocks() {
        // Fetch all customers
        List<CustomerWithStocksDTO> customers = customerServiceClient.getAllCustomers();

        // Fetch all stocks
        List<CustomerWithStocksDTO> stocks = stockServiceClient.getAllStocks();

        // Combine data into CustomerWithStocksDTO
        List<CustomerWithStocksDTO> result = new ArrayList<>();
        for (CustomerWithStocksDTO customer : customers) {
            for (CustomerWithStocksDTO stock : stocks) {
                // Check if the stock belongs to the customer based on email
                if (stock.getEmail() != null && stock.getEmail().equalsIgnoreCase(customer.getEmail())) {
                    CustomerWithStocksDTO combined = new CustomerWithStocksDTO(
                        customer.getEmail(),
                        stock.getCompany(),
                        stock.getCurrentPrice(),
                        stock.getInitialPrice(),
                        stock.getQuantity()
                    );
                    result.add(combined);
                }
            }
        }

        return result;
    }

    // Method to add a stock by calling StockServiceClient
    public CustomerWithStocksDTO addStock(CustomerWithStocksDTO stock) {
        return stockServiceClient.addStock(stock);
    }

    // Method to get all stocks by calling StockServiceClient
    public List<CustomerWithStocksDTO> getAllStocks() {
        return stockServiceClient.getAllStocks();
    }

    // Method to get all customers by calling CustomerServiceClient
    public List<CustomerWithStocksDTO> getAllCustomers() {
        return customerServiceClient.getAllCustomers();
    }
}

