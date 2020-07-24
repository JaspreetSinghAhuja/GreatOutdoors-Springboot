package com.capg.GO_Product_Management.service;

import java.util.List;

import com.capg.GO_Product_Management.entity.Product;


public interface ProductServiceI {
	
	public List<Product> getAllProducts();
	public Product getProductById(Long productId);
	
	public boolean addProduct(Product product,Long productMasterId);
	public boolean updateProduct(Product product,Long productMasterId);
	public boolean deleteProductById(Long productId,Long productMasterId);

}
