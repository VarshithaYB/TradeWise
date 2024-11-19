package com.tradewise.stockservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;
import com.tradewise.stockservice.model.Wallet;
import com.tradewise.stockservice.repository.StockRepository;
import com.tradewise.stockservice.repository.WalletRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
    private WalletRepository walletRepository;


	@Override
	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public Stock buyStock(String stockId, int quantity, double price, String userId) throws StockNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + stockId));
        
        stock.setQuantity(stock.getQuantity() + quantity);
        stockRepository.save(stock);

        // Update the wallet balance
        Wallet wallet = walletRepository.findByUserId(userId);
        double totalCost = quantity * price;
        wallet.reduceMoney(totalCost);
        walletRepository.save(wallet);

        return stock;
	}

	@Override
	public List<Stock> getAllStocks() {
		return stockRepository.findAll();
	}

//	@Override
//	 public Stock sellStock(String stockId, int quantity, double price, String userId) throws StockNotFoundException {
//	        Stock stock = stockRepository.findById(stockId)
//	                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + stockId));
//	        
//	        if (stock.getQuantity() < quantity) {
//	            throw new IllegalArgumentException("Insufficient stock quantity");
//	        }
//
//	        // Update the stock quantity
//	        stock.setQuantity(stock.getQuantity() - quantity);
//	        stockRepository.save(stock);
//
//	        // Update the wallet balance (credit the user with the sale amount)
//	        Wallet wallet = walletRepository.findByUserId(userId);
//	        double totalRevenue = quantity * price;
//	        wallet.addMoney(totalRevenue);
//	        walletRepository.save(wallet);
//
//	        return stock;
//	    }

	@Override
	public Stock updateStock(String stockId, Stock updatedStock) throws StockNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + stockId));
        stock.setCompany(updatedStock.getCompany());
        stock.setSymbol(updatedStock.getSymbol());
        stock.setCurrentPrice(updatedStock.getCurrentPrice());
        stock.setInitialPrice(updatedStock.getInitialPrice());
        stock.setQuantity(updatedStock.getQuantity());
        return stockRepository.save(stock);
    }
	
	@Override
	public Stock sellStock(String stockId, int quantity,double price) throws StockNotFoundException {
	    Stock stock = stockRepository.findById(stockId)
	            .orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + stockId));

	    // Ensure there is enough stock to sell
	    if (stock.getQuantity() < quantity) {
	        throw new IllegalArgumentException("Not enough stock to sell");
	    }

	    // Reduce the stock quantity
	    stock.setQuantity(stock.getQuantity() - quantity);

	    // Save the updated stock and return it
	    return stockRepository.save(stock);
	}
	
	
	

}
