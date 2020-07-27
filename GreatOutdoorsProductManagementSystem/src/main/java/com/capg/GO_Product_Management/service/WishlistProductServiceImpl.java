package com.capg.GO_Product_Management.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.GO_Product_Management.dao.WishlistProductdao;
import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.entity.WishlistProduct;
import com.capg.GO_Product_Management.exception.ProductException;


@Service
public class WishlistProductServiceImpl implements IWishlistProductService {

	@Autowired
	private WishlistProductdao wishlistProductdao;


	@Override
	public boolean addToWishlist(WishlistProduct addItem) throws ProductException  {
		boolean status=wishlistProductdao.save(addItem) != null;
		if(status)
		{
			return true;
		}
		else
		{
			throw new ProductException("Unable to insert in wishlist");
		}
	}
	
	/*
	 * name - delete item from the wishlist
	 * description - it will delete available item from the wishlist
	 */
	

	@Override
	public boolean deleteProduct(WishlistProduct removeItem) throws ProductException {
		boolean status=wishlistProductdao.save(removeItem) != null;
		if(status)
		{
			return true;
		}
		else
		{
			throw new ProductException("Unable to insert in wishlist");
		}
	}


	 /*
     * showProductsFromWishlist
     * descriptio:shows all products in the wishlist
     */
	
	
	@Override
	public List<WishlistProduct> viewAllItems() throws ProductException {
		if(wishlistProductdao.count()==0)
		{
		List<WishlistProduct> list = new ArrayList<>();
		return (List<WishlistProduct>) wishlistProductdao.findAll();
	}
		else
		{
			throw new ProductException("Wishlist is empty");
		}
	}
}
