package com.capg.GO_Product_Management.service;

import java.util.List;

import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.entity.WishlistProduct;
import com.capg.GO_Product_Management.exception.ProductException;


public interface IWishlistProductService {
	public boolean create(WishlistProduct product) throws ProductException;
	public List<Product> retrive(long userId) throws ProductException;
	public boolean checkId(long userId, long productId) throws ProductException;
	public boolean deleteProduct(long userId, long productId) throws ProductException;
}
