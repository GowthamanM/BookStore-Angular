package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.CartItemModel;

public interface CartItemRepository extends JpaRepository<CartItemModel, String> {

}
