package com.capg.GO_Product_Management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.GO_Product_Management.dao.UserDAO;
import com.capg.GO_Product_Management.entity.User;


@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	UserDAO userDao;
	
	@Override
	public User getUserById(Long userId) {
		if(userId!=null && userId>0) 
		{
		 return userDao.findById(userId).orElse(null);	
		}
		else
		{
			return null;
		}
	}

	@Override
	public User signIn(String userName, String userPassword) {
		User user=userDao.findByUserName(userName);
		if(user!=null && user.getUserName().contentEquals(userName) && user.getUserPassword().contentEquals(userPassword))
		{
			return user;
		}
		else
		   return null;
	}

	@Override
	public boolean signUp(Optional<Long> adminUserId, User newUser) {
		
		if(adminUserId!=null && adminUserId.orElse(0l)>0)
		{
			User user=getUserById(adminUserId.orElse(0l));
		  	if(user!=null && user.getUserRole()==1)
		  	{
		  		if(newUser!=null)
		  		{
		  		//Check newUser already exist
			  		if(userDao.findByUserName(newUser.getUserName())!=null)
			  		{
			  			return false;
			  		}
			  		else
			  		{
			  		 newUser.setUserRole(2);
			  		 userDao.save(newUser);
			  		    return true;
			  		}	
		  		}
		  		else
		  			return false;
		  		
		  	}
		  	else
		  		return false;
		}
		else
		{
			if(newUser!=null)
			{
				if(userDao.findByUserName(newUser.getUserName())!=null)
					return false;
				else
				{
					newUser.setUserRole(3);
					userDao.save(newUser);
					return true;
				}
			}
			else
				return false;
		}
	}

	@Override
	public User findById(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
