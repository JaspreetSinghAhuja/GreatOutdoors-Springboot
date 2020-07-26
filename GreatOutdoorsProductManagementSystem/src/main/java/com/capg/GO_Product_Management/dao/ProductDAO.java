package com.capg.GO_Product_Management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.GO_Product_Management.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

	boolean checkProductId(long productId);

	

}
