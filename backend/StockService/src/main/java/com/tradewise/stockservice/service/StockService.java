package com.tradewise.stockservice.service;

import java.util.List;

import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;

public interface StockService {
	
	Stock addStock(Stock stock);
    Stock buyStock(String stockId, int quantity, double price, String email);
    List<Stock> getAllStocks();
    //Stock sellStock(String stockId, int quantity, double price) throws StockNotFoundException;
    Stock updateStock(String stockId, Stock updatedStock);
    void sellStock(String company, int quantity, double price);
	void deleteStock(String company);

    
//    List<Stock> getStocksByUserId(String userId);
    
    List<Stock> getStocksByEmail(String email);

    
}

