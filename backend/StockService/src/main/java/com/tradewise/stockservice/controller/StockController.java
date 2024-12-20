

package com.tradewise.stockservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.tradewise.stockservice.request.StockRequest;

import com.tradewise.stockservice.dto.StockRequest;
import com.tradewise.stockservice.exception.StockNotFoundException;
import com.tradewise.stockservice.model.Stock;
import com.tradewise.stockservice.request.SellStockRequest;
import com.tradewise.stockservice.service.StockService;

@RestController
@CrossOrigin(origins="http://localhost:4202")
@RequestMapping("/api/stocks")
public class StockController {
	
	@Autowired
    private StockService stockService;

    @PostMapping("/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
    	try {
    		Stock addedStock=stockService.addStock(stock);
    		System.out.println("Recieved stock: "+addedStock);
    		
   
    		return ResponseEntity.ok(addedStock);
    	}
    	catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	}
    }

    

//    @PutMapping("/buy/{stockId}")
//    public Stock buyStock(@PathVariable String stockId, @RequestParam int quantity, @RequestParam double price, @RequestParam String userId) throws StockNotFoundException {
//        return stockService.buyStock(stockId,quantity, price, userId);
//    }
    
    
    @PostMapping("/buy")
    public Stock buyStock(@RequestBody StockRequest stockRequest) throws StockNotFoundException {
        return stockService.buyStock(
                stockRequest.getStockId(),
                stockRequest.getQuantity(),
                stockRequest.getPrice(),
                stockRequest.getUserId()
        );
    }


//    @DeleteMapping("/sell")
//    public ResponseEntity<Stock> sellStock(@RequestBody StockRequest stockRequest) throws StockNotFoundException {
//        return ResponseEntity.ok(stockService.sellStock(
//                stockRequest.getStockId(),
//                stockRequest.getQuantity(),
//                stockRequest.getPrice(),
//                stockRequest.getUserId()));
//        
//       
//    }
    
//    @PutMapping("/sell")
//    public ResponseEntity<Stock> sellStock(@RequestBody StockRequest sellStockRequest) {
//        // Logic to decrease the stock quantity in the database
//        Stock updatedStock = stockService.sellStock(sellStockRequest.getStockId(), sellStockRequest.getQuantity());
//        return ResponseEntity.ok(updatedStock);
//    }
//
    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
    
    
//    @DeleteMapping("/sell/{stockId}")
//    public Stock sellStock(@PathVariable String stockId, @RequestParam int quantity, @RequestParam double price, @RequestParam String userId) throws StockNotFoundException {
//        return stockService.sellStock(stockId, quantity, price, userId);
//    }
    
    
//    @PutMapping("/sell")
//    public ResponseEntity<Stock> updateStock(@PathVariable String stockId, @RequestBody Stock updatedStock) throws StockNotFoundException {
//        Stock stock = stockService.updateStock(stockId, updatedStock);
//        return new ResponseEntity<>(stock, HttpStatus.OK);
//    }
    
//    @PostMapping("/sellStock")
//    public ResponseEntity<String> sellStock(@RequestBody SellStockRequest request) {
//        if (request.getCompanyName() == null || request.getQuantity() <= 0 || request.getPrice() <= 0) {
//            return ResponseEntity.badRequest().body("Invalid input");
//        }
//        stockService.sellStock(request.getCompanyName(), request.getQuantity(), request.getPrice());
//        return ResponseEntity.ok("Stock sold successfully");
//    }
//    @PostMapping("/sellStock")
//    public ResponseEntity<Stock> sellStock(@RequestBody SellStockRequest request) {
//        if (request.getCompanyName() == null || request.getQuantity() <= 0 || request.getPrice() <= 0) {
//            return ResponseEntity.badRequest().body(null); // Return null if the input is invalid
//        }
//        Stock updatedStock = stockService.sellStock(request.getCompanyName(), request.getQuantity(), request.getPrice());
//        return ResponseEntity.ok(updatedStock); // Return the updated stock object
//    }

//
//
//
//}

//package com.tradewise.stockservice.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tradewise.stockservice.dto.StockRequest;
//import com.tradewise.stockservice.exception.StockNotFoundException;
//import com.tradewise.stockservice.model.Stock;
//import com.tradewise.stockservice.request.SellStockRequest;
//import com.tradewise.stockservice.service.StockService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4202")
//@RequestMapping("/api/stocks")
//public class StockController {
//
//    @Autowired
//    private StockService stockService;
//
//    // Add a new stock
//    @PostMapping("/add")
//    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
//        try {
//            Stock addedStock = stockService.addStock(stock);
//            return ResponseEntity.ok(addedStock);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    // Buy a stock
//    @PostMapping("/buy")
//    public ResponseEntity<Stock> buyStock(@RequestBody StockRequest stockRequest) {
//        try {
//            Stock purchasedStock = stockService.buyStock(
//                    stockRequest.getStockId(),
//                    stockRequest.getQuantity(),
//                    stockRequest.getPrice(),
//                    stockRequest.getEmail());
//            return ResponseEntity.ok(purchasedStock);
//        } catch (StockNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//    // Sell a stock
//    @PostMapping("/sellStock")
//    public ResponseEntity<Stock> sellStock(@RequestBody SellStockRequest request) {
//        if (request.getCompanyName() == null || request.getQuantity() <= 0 || request.getPrice() <= 0) {
//            return ResponseEntity.badRequest().body(null);
//        }
//        try {
//            Stock updatedStock = stockService.sellStock(request.getCompanyName(), request.getQuantity(), request.getPrice());
//            return ResponseEntity.ok(updatedStock);
//        } catch (StockNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }

//    
//    
    @PostMapping("/sellStock")
    public ResponseEntity<Map<String,String>> sellStock(@RequestBody StockRequest request) {
        stockService.sellStock(request.getCompany(), request.getQuantity(), request.getPrice());
        return ResponseEntity.ok(Map.of("message","Stock sold  successfully"));
    }

    @DeleteMapping("/deleteStock/{company}")
    public ResponseEntity<Map<String,String>> deleteStock(@PathVariable String company) {
        stockService.deleteStock(company);
        return ResponseEntity.ok(Map.of("message","Stock deleted successfully"));

    }
//
//    // Get all stocks
//    @GetMapping("/all")
//    public ResponseEntity<List<Stock>> getAllStocks() {
//        try {
//            List<Stock> stocks = stockService.getAllStocks();
//            return new ResponseEntity<>(stocks, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//    
//    @GetMapping("/stocks/{userId}")
//    public List<Stock> getStocksByUserId(@PathVariable String userId) {
//        return stockService.getStocksByUserId(userId);
//    }
//    
    @GetMapping("/by-email/{email}")
    public ResponseEntity<List<Stock>> getStocksByEmail(@PathVariable String email) {
        List<Stock> stocks = stockService.getStocksByEmail(email);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
//    
//    
}
