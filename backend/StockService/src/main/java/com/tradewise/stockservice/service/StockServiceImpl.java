package com.tradewise.stockservice.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;
//import com.tradewise.stockservice.model.Wallet;
import com.tradewise.stockservice.repository.StockRepository;
//import com.tradewise.stockservice.repository.WalletRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepository;
	
//	@Autowired
//    private WalletRepository walletRepository;


	@Override
	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public Stock buyStock(String stockId, int quantity, double price, String email) throws StockNotFoundException {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with id " + stockId));
        
        stock.setQuantity(stock.getQuantity() + quantity);
       
        return stockRepository.save(stock);

        // Update the wallet balance
//        Wallet wallet = walletRepository.findByUserId(userId);
//        double totalCost = quantity * price;
//        wallet.reduceMoney(totalCost);
//        walletRepository.save(wallet);

        
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
	
//	@Override
//	public Stock sellStock(String stockId, int quantity,double price) throws StockNotFoundException {
//	    Stock stock = stockRepository.findById(stockId)
//	            .orElseThrow(() -> new StockNotFoundException("Stock not found with id: " + stockId));
//
//	    // Ensure there is enough stock to sell
//	    if (stock.getQuantity() < quantity) {
//	        throw new IllegalArgumentException("Not enough stock to sell");
//	    }
//
//	    // Reduce the stock quantity
//	    stock.setQuantity(stock.getQuantity() - quantity);
//
//	    // Save the updated stock and return it
//	    return stockRepository.save(stock);
//	}
	

//	public void sellStock(String company, int quantity, double price) {
//        Optional<Stock> optionalStock = stockRepository.findByCompany(company);
//
//        if (optionalStock.isEmpty()) {
//            throw new RuntimeException("Stock not found");
//        }
//
//        Stock stock = optionalStock.get();
//
//        if (quantity <= 0) {
//            stockRepository.delete(stock); // Delete stock if quantity is 0 or less
//        } else {
//            stock.setQuantity(quantity);
//            stock.setCurrentPrice(price);
//            stockRepository.save(stock); // Update the stock
//        }
//    }

	
	
	public void sellStock(String company, int quantity, double price) {
	    Optional<Stock> optionalStock = stockRepository.findByCompany(company);
	    System.out.println("Stock retrieved: {}"+optionalStock);


	    if (optionalStock.isEmpty()) {
	        throw new StockNotFoundException("Stock not found for company: " + company);
	    }

	    Stock stock = optionalStock.get();

	    if (quantity <= 0) {
	        throw new StockNotFoundException("Quantity must be greater than 0");
	    }


	    int newQuantity = stock.getQuantity() - quantity; // Subtract the sold quantity from the existing quantity

	    if (newQuantity < 0) {
	        throw new RuntimeException("Insufficient stock to sell");
	    } else if (newQuantity == 0) {
	        stockRepository.delete(stock); // Delete stock if the resultant quantity is 0
	    } else {
	        stock.setQuantity(newQuantity);
	        stock.setCurrentPrice(price);
	        stockRepository.save(stock); // Update the stock with new quantity and price
	    }
	}



    public void deleteStock(String company) {
        Optional<Stock> optionalStock = stockRepository.findByCompany(company);

        if (optionalStock.isEmpty()) {
            throw new RuntimeException("Stock not found");
        }

        stockRepository.delete(optionalStock.get()); // Explicitly delete the stock
    }

	
	
//	 @Override
//	    public List<Stock> getStocksByUserId(String userId) {
//	        // Retrieve stocks associated with the user
//	        return stockRepository.findByUserId(userId);
//	    }

	 
	 public List<Stock> getStocksByEmail(String email) {
		 List<Stock> stocks = stockRepository.findByEmail(email);
	        System.out.println("Stocks found for email " + email + ": " + stocks);
	        return stocks;
	    }
	
	

}
