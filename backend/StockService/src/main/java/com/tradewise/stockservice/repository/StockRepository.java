package com.tradewise.stockservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tradewise.stockservice.model.Stock;


@Repository
public interface StockRepository extends MongoRepository<Stock, String>{

Optional<Stock> findByCompanyName(String companyName);

}
