package com.tradewise.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
	
	private String company;
    private String symbol;
    private double currentPrice;
    private double initialPrice;
    private int quantity;

}
