package com.capg.GO_Product_Management.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.GO_Product_Management.entity.WishlistProduct;
import com.capg.GO_Product_Management.exception.ProductException;
import com.capg.GO_Product_Management.exception.UserException;
import com.capg.GO_Product_Management.service.IWishlistProductService;
import com.capg.GO_Product_Management.service.ProductServiceI;
import com.capg.GO_Product_Management.service.UserServiceI;


@CrossOrigin(origins="*")
@RestController
public class WishlistController {
	@Autowired
	private ProductServiceI ProductService;
	@Autowired
	private UserServiceI userService;
	@Autowired
	private IWishlistProductService wishlistProductService;
 

	
	 //*********Wishlist Operation***************
	   
	
	
	
	   /*
	    * This method will like the product with respective user and save it to the wishlist.
	    */
	   
	 
	@PostMapping(value="/addtoWishlist",consumes="application/json")
	public String addToWishlist(@RequestBody WishlistProduct addItem) throws ProductException
	{   
		wishlistProductService.addToWishlist(addItem);
		return "Added to wishlist";
		
	}
	
	   
	   /*
	    * This method will delete the particular Product from wishlist with respect to the particular user.
	    */
	@PostMapping(value="/deleteProduct",consumes="application/json")
	public String deleteProduct(@RequestBody WishlistProduct removeItem ) throws ProductException
	{   
		wishlistProductService.deleteProduct(removeItem);
		return "Removed from wishlist";
		
	}
	
	
	   /*
	    * This method will return List of Product Liked by the particular user
	    */

	
	@GetMapping(value="/viewAll")
	public List<WishlistProduct> viewAllItems()  throws ProductException {
		List<WishlistProduct> list = wishlistProductService.viewAllItems();
		return list;
	}
	

}
