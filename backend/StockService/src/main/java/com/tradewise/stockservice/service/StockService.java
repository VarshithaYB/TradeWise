package com.tradewise.stockservice.service;

import java.util.List;

import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;

public interface StockService {
	
	Stock addStock(Stock stock);
    Stock buyStock(String stockId, int quantity, double price, String userId);
    List<Stock> getAllStocks();
    Stock sellStock(String stockId, int quantity, double price) throws StockNotFoundException;
    Stock updateStock(String stockId, Stock updatedStock);
    
}

