package com.tradewise.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	
	private String stockId;
    private String company;
    private String symbol;
    private double currentPrice;
    private double initialPrice;
    private int quantity;

}
