package com.jam.orderapi.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.orderapi.entity.CartItems;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {

}
