package com.tradewise.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//import com.tradewise.admin.dto.CustomerDTO;
import com.tradewise.admin.dto.CustomerWithStocksDTO;

@FeignClient(name = "customer-service", url = "http://localhost:8081") // URL for CustomerService
public interface CustomerServiceClient {

    @GetMapping("/api/customers")
    List<CustomerWithStocksDTO> getAllCustomers();
}
