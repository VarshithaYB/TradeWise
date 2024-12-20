package com.tradewise.stockservice.repository;

import java.util.List;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tradewise.stockservice.model.Stock;


@Repository
public interface StockRepository extends MongoRepository<Stock, String>{
	
//	List<Stock> findByUserId(String userId);
	
	List<Stock> findByEmail(String email);


	Optional<Stock> findByCompany(String company);


}
