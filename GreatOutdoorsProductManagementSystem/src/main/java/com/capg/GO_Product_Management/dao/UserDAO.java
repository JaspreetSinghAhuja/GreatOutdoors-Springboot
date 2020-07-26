package com.capg.GO_Product_Management.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.GO_Product_Management.entity.User;

/**
 * spring implements implementation for all methods 
 * no transaction or entity manager needs to be maintained by developer whole is managed by spring
 * 
 * @author aravind
 */
@Repository
public interface UserDAO  extends JpaRepository<User, Long>{

	public User findByUserName(String userName);

	public boolean checkUserId(long userId);

}
