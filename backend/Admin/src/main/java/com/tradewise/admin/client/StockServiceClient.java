package com.tradewise.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tradewise.admin.dto.CustomerWithStocksDTO;
//import com.tradewise.admin.dto.StockDTO;

@FeignClient(name = "stock-service", url = "http://localhost:5050") // URL for StockService-8081
public interface StockServiceClient {

    @PostMapping("/api/stocks/add")
    CustomerWithStocksDTO addStock(@RequestBody CustomerWithStocksDTO stock);

    @GetMapping("/api/stocks/all")
    List<CustomerWithStocksDTO> getAllStocks();
    
    
}
