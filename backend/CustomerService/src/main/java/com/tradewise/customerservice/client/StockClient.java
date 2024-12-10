package com.tradewise.customerservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;

import com.tradewise.customerservice.model.Stock;

@FeignClient(name = "stock-service", url = "http://localhost:5050")  // URL can be changed based on your setup
public interface StockClient {
    
	@GetMapping("/by-email/{email}")
	List<Stock> getStocksByEmail(@PathVariable("email") String email);
    
}


