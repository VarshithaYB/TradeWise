package com.tradewise.stockservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "stocks")
public class Stock {
	
	@Id
    private String stockId;
    private String company;
    private String symbol;
    private double currentPrice;
    private double initialPrice;
    private int quantity;

}
