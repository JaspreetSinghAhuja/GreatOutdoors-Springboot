package com.capg.GO_Product_Management.service;



import java.util.Optional;

import com.capg.GO_Product_Management.entity.User;


public interface UserServiceI {

	public User getUserById(Long userId);
	
	public User signIn(String userName,String userPassword);
	
	public boolean signUp(Optional<Long> adminId,User newUser);

	public User findById(long userId);
}
