package com.swagger.demo.controller;

import com.swagger.demo.entity.Product;
import com.swagger.demo.model.Products;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Product-API")
public interface ProductApi {

	@ApiOperation(value = "Get list of products in the System ", response = Products.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!"),
			@ApiResponse(code = 500, message = "Internal Server Error!") })
	public Products getProductList();

	@ApiOperation(value = "Get product by product ID", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!"),
			@ApiResponse(code = 500, message = "Internal Server Error!") })
	public Product getProduct(Long productId);

	@ApiOperation(value = "Create product", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess : Product created"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!"),
			@ApiResponse(code = 500, message = "Internal Server Error!") })
	public String createProduct(Product product);

	@ApiOperation(value = "Update product by product ID", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess : Product Updated"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!"),
			@ApiResponse(code = 500, message = "Internal Server Error!") })
	public String updateProduct(Long productId, Product product);

	@ApiOperation(value = "Delete product by product ID", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess : Product deleted"),
			@ApiResponse(code = 401, message = "Not authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not found!"),
			@ApiResponse(code = 500, message = "Internal Server Error!") })
	public String deleteProduct(Long productId);

}
