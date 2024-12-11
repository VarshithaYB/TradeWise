package com.tradewise.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWithStocksDTO {
	
	private String email;

    private String company;

    private double currentPrice;
    private double initialPrice;
    private int quantity;

}
