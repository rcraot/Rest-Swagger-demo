package com.swagger.demo.model;

import java.util.List;

import com.swagger.demo.entity.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Products {

	@ApiModelProperty(example = "[{\"id\": 1, \"name\": \"product name\", \"description\": \"product description\" }, {\"id\": 1, \"name\": \"product name\", \"description\": \"product description\" }]", required = true)
	private List<Product> products;

	public Products() {

	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
