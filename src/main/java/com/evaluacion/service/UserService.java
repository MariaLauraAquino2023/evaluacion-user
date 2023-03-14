package com.evaluacion.service;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.dto.response.CreateUserResponse;
import com.evaluacion.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

	public List<User> getAllUser();

	public User getUserById(UUID id);

	public CreateUserResponse createUser(CreateUserRequest req);

	public void deleteUserById(UUID user);
}