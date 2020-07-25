package com.capg.GO_Product_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.GO_Product_Management.dao.ProductDAO;
import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.entity.User;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	UserServiceI userService;

	@Override
	public List<Product> getAllProducts() {
		
		return productDao.findAll();
	}
	
	@Override
	public Product getProductById(Long productId) {
		return productDao.findById(productId).orElse(null);
	}

	@Override
	public boolean addProduct(Product product, Long productMasterId) {
		User user=userService.getUserById(productMasterId);
		if(user!=null)
		{
		   if(user.getUserRole()==2)
		   {
			   product.setProductMaster(user);
			   productDao.save(product);
			return productDao.existsById(product.getProductId());  
		   }
		   else
			   return false;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product, Long productMasterId) {
		User user=userService.getUserById(productMasterId);
		if(user!=null)
		{
		   if(user.getUserRole()==2)
		   {
			  Product p=getProductById(product.getProductId());
			 if(p.getProductMaster().getUserId()==productMasterId)
			 {
				 product.setProductMaster(user);
				   productDao.save(product);
				return productDao.existsById(product.getProductId());  
			 }
			 else
			 {
				 return false;
			 }
		   }
		   else
			   return false;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteProductById(Long productId, Long productMasterId) {
		User user=userService.getUserById(productMasterId);
		if(user!=null)
		{
		   if(user.getUserRole()==2)
		   {
			  Product p=getProductById(productId);
			 if(p.getProductMaster().getUserId()==productMasterId)
			 {
				    productDao.deleteById(productId);
					return !productDao.existsById(productId);  
			 }
			 else
			 {
				 return false;
			 }
		   }
		   else
			   return false;
		}
		else
		{
			return false;
		}
		 
	}

	
	
}
