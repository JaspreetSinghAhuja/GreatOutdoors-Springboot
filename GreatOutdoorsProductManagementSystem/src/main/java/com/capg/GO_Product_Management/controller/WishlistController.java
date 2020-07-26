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
import com.capg.GO_Product_Management.service.UserServiceI;


@CrossOrigin(origins="*")
@RestController
public class WishlistController {

	@Autowired
	private IWishlistProductService wishlistProductService;
	
	@Autowired
	private UserServiceI userService;
 

	 //////////////////////////////////////////////////////////////////////////////
   
  //*********Wishlist Operation***************
   
   /*
    * This method will like the product with respective user and save it to the wishlist.
    */
   
   @GetMapping(value="/user/{userId}/{productId}")
   public void addToWislist(@PathVariable long userId,@PathVariable long productId) throws ProductException, UserException
   {   
	    if(!wishlistProductService.checkId(userId, productId))
	    {
	    	WishlistProduct product=new WishlistProduct(productId);
	    	product.setUser(userService.findById(userId));
	    	wishlistProductService.create(product);
	    }  
	    
   }
   
   /*
    * This method will delete the particular Product from wishlist with respect to the particular user.
    */
   @DeleteMapping(value="/user/{userId}/{productId}")
   public void deleteProduct(@PathVariable long userId,@PathVariable long productId) throws ProductException
   {   
	   wishlistProductService.deleteProduct(userId, productId);
	 
   }
   
   /*
    * This method will return List of Product Liked by the particular user
    */
   
   @GetMapping(value="/wishlistproduct/{userId}")
	public List fetchProduct(@PathVariable long userId) throws ProductException
	{  
	    
	    return wishlistProductService.retrive(userId);
	}
  
   
   
   
   
   ///////////////////////////////////////////

}
