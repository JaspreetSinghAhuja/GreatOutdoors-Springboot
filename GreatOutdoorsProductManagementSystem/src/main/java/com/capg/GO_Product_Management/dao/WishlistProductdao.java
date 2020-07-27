package com.capg.GO_Product_Management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.GO_Product_Management.entity.WishlistProduct;



public interface WishlistProductdao extends JpaRepository<WishlistProduct,String>
{

}
