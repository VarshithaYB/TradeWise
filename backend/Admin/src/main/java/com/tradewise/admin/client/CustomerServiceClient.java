package com.tradewise.admin.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tradewise.admin.dto.CustomerDTO;

@FeignClient(name = "customer-service", url = "http://localhost:8081") // URL for CustomerService
public interface CustomerServiceClient {

    @GetMapping("/customers/all")
    List<CustomerDTO> getAllCustomers();
}
