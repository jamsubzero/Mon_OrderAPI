package com.jam.orderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.orderapi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
