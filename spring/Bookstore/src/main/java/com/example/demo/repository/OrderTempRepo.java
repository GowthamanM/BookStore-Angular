package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.OrderTemp;

@Repository
public interface OrderTempRepo extends CrudRepository<OrderTemp, String>{

}
