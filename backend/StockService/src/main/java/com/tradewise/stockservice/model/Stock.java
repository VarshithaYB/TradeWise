package com.tradewise.stockservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	

	@JsonProperty("company")
    private String company;

	@JsonProperty("symbol")
    private String symbol;
    private double currentPrice;
    private double initialPrice;
    private int quantity;
    
    private String email;

}

