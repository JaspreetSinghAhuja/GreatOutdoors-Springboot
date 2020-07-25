package com.capg.GO_Product_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.service.ProductServiceI;
import com.capg.GO_Product_Management.service.ProductServiceImpl;


@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private ProductServiceI productServiceI;
	
	  @GetMapping(value="/showallproducts")
	  public List<Product> showAllProducts()
	  {
		  return (List<Product>) productServiceImpl.getAllProducts();
	  }
	  
	  @GetMapping(value="/getproductbyid/{productId}",produces = {"application/json","application/xml"})
		public ResponseEntity<Object> getProductById(@PathVariable("productId") long productId)
		{
			if(productId>0)
			{
			  Product product=productServiceI.getProductById(productId);
			  
			  if(product==null)
			  {
				return new ResponseEntity<>("Product Doesn't exist",HttpStatus.BAD_REQUEST);
			  }
			  else
			  {
				return new ResponseEntity<>(product,HttpStatus.OK);
			  }
			}
			else
			{
				return new ResponseEntity<>("Product Id InValid",HttpStatus.BAD_REQUEST);
			}
		}
	  @PostMapping(value = "/addproduct/{productMasterId}")
		public ResponseEntity<Object> addProduct(@PathVariable("productMasterId") long productMasterId, @Valid @RequestBody Product product,BindingResult bindingResult)
		{
		  if(productServiceI.addProduct(product,productMasterId))
			{
			 return new ResponseEntity<>("product Added Successfully!",HttpStatus.OK);
			}
			 else
				return new ResponseEntity<>("Unable to add product",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	  
	  
	  
	  
	  @DeleteMapping(value="/deleteproduct/{productMasterId}/{productid}")
		public ResponseEntity<Object> deleteProductById(@PathVariable("productMasterId") long productMasterId, @PathVariable("productid") long productId)
		{
			
		      productServiceI.deleteProductById(productId,productMasterId);
			  return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.NO_CONTENT);	
		}
	  	
	
}
