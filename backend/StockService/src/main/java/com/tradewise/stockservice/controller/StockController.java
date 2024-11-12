package com.tradewise.stockservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tradewise.stockservice.dto.StockRequest;
import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;
import com.tradewise.stockservice.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
    private StockService stockService;

    @PostMapping("/add")
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }
    

//    @PutMapping("/buy/{stockId}")
//    public Stock buyStock(@PathVariable String stockId, @RequestParam int quantity, @RequestParam double price, @RequestParam String userId) throws StockNotFoundException {
//        return stockService.buyStock(stockId,quantity, price, userId);
//    }
    
    @PostMapping("/buy")
    public Stock buyStock(@RequestBody StockRequest stockRequest) throws StockNotFoundException {
        return stockService.buyStock(stockRequest.getStockId(), stockRequest.getQuantity(), stockRequest.getPrice(), stockRequest.getUserId());
    }

    @DeleteMapping("/sell")
    public Stock sellStock(@RequestBody StockRequest stockRequest) throws StockNotFoundException {
        return stockService.sellStock(stockRequest.getStockId(), stockRequest.getQuantity(), stockRequest.getPrice(), stockRequest.getUserId());
    }
    

    @GetMapping("/all")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
    
    
//    @DeleteMapping("/sell/{stockId}")
//    public Stock sellStock(@PathVariable String stockId, @RequestParam int quantity, @RequestParam double price, @RequestParam String userId) throws StockNotFoundException {
//        return stockService.sellStock(stockId, quantity, price, userId);
//    }
    
    
    @PutMapping("/update/{stockId}")
    public Stock updateStock(@PathVariable String stockId, @RequestBody Stock updatedStock) throws StockNotFoundException {
        return stockService.updateStock(stockId, updatedStock);
    }

}
