package com.Controller;

import com.Entity.UserEntity;
import com.Service.UserService;

public class UserController {

	UserService service = new UserService();

	public void saveUser(UserEntity user) {
		service.saveUser(user);

	}

}
