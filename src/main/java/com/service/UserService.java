package com.service;

import org.springframework.stereotype.Service;

import com.model.UserResponseModel;

@Service
public interface UserService {

	public UserResponseModel getUserById(String id);
}
