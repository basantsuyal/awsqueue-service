package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.UserResponseModel;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserResponseModel user;

	@Override
	public UserResponseModel getUserById(String id) {
		user.setId(id);
		user.setFirstName("Basant");
		user.setLastName("Suyal");
		user.setAge("30");
		return user;
	}

}
