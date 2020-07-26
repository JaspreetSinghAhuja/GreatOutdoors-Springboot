package com.capg.GO_Product_Management.dao;

import java.util.List;

import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.entity.WishlistProduct;
import com.capg.GO_Product_Management.exception.ProductException;



public interface IWishlistProductDao {

	public boolean create(WishlistProduct product);

	public List<Product> retrive(long userId);

	public boolean checkId(long userId, long productId) throws ProductException;

	public boolean deleteProduct(long userId, long productId);

}
