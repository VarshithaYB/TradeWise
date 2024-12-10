package com.tradewise.stockservice.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

	
	private String company;
	private int quantity;
	private double price;
	
	
	
}
