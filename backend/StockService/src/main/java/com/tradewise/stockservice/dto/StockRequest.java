package com.tradewise.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {
	
	private String company;
	private String stockId;
    private int quantity;
    private double price;

    private String email;


    private String userId;


	
	

}
