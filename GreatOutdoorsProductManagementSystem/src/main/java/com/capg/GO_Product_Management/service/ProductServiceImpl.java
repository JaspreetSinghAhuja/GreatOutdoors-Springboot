package com.capg.GO_Product_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.GO_Product_Management.dao.ProductDAO;
import com.capg.GO_Product_Management.entity.Product;

@Service
public class ProductServiceImpl implements ProductServiceI {

	@Autowired
	private ProductDAO productDao;

	@Override
	public List<Product> getAllProducts() {
		
		return productDao.findAll();
	}
	
	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(Product product, Long productMasterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product, Long productMasterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductById(Long productId, Long productMasterId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
