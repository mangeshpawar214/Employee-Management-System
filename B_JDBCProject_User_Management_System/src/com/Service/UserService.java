package com.Service;

import com.Dao.UserDao;
import com.Entity.UserEntity;

public class UserService {

	UserDao dao = new UserDao();
	
	
	
	public void  saveUser(UserEntity user)
	{
			dao.saveUser(user);
		
	}
}
