package com.swagger.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swagger.demo.entity.Product;
import com.swagger.demo.repository.ProductRepository;
import com.swagger.demo.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

}
