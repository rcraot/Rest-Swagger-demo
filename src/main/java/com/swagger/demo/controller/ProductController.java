package com.swagger.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.demo.entity.Product;
import com.swagger.demo.exception.ProductNotFoundException;
import com.swagger.demo.model.Products;
import com.swagger.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController implements ProductApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@Override
	@GetMapping()
	public Products getProductList() {
		Products products = new Products();
		products.setProducts(service.findAll());
		return products;
	}

	@Override
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable(value = "productId") Long productId) {
		LOGGER.info(" productId : " + productId);
		return service.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found for the Id : ", productId));
	}

	@Override
	@PostMapping()
	public String createProduct(@RequestBody Product product) {
		service.save(product);
		return "Product added";
	}

	@Override
	@PutMapping("/{productId}")
	public String updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody Product product) {
		return service.findById(productId).map(p -> {
			p.setName(product.getName());
			p.setDescription(product.getDescription());
			service.save(p);
			return "Product updated";
		}).orElseThrow(() -> new ProductNotFoundException("Product not found for the Id : ", productId));
	}

	@Override
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") Long productId) {
		return service.findById(productId).map(p -> {
			service.deleteById(productId);
			return "Product deleted";
		}).orElseThrow(() -> new ProductNotFoundException("Product not found for the Id : ", productId));
	}

}
