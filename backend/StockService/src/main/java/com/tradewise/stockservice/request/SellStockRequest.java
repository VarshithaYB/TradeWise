package com.tradewise.stockservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellStockRequest {
	
	 private String company;
	    private int quantity;
	    private double price;

}
