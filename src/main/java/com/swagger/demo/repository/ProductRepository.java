package com.swagger.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swagger.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
