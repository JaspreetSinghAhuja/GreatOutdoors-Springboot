package com.capg.GO_Product_Management.service;

import java.util.List;

import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.entity.WishlistProduct;
import com.capg.GO_Product_Management.exception.ProductException;


public interface IWishlistProductService {
	public boolean addToWishlist(WishlistProduct addItem) throws ProductException;
	public List<WishlistProduct> viewAllItems() throws ProductException;
	public boolean deleteProduct(WishlistProduct removeItem) throws ProductException;
}
