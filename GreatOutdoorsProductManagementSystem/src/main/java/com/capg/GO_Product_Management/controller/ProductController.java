package com.capg.GO_Product_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capg.GO_Product_Management.entity.Product;
import com.capg.GO_Product_Management.service.ProductServiceImpl;


@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	  @GetMapping(value="/showallproducts")
	  public List<Product> fetchStudent()
	  {
		  return (List<Product>) productServiceImpl.getAllProducts();
	  }
	  	
	
}
