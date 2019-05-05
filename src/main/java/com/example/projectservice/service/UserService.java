package com.example.projectservice.service;

import com.example.projectservice.entity.Users;
import com.example.projectservice.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {
	@Inject
	UsersRepository usersRepository;

	public List<Users> getList() {
		return usersRepository.findAll();
	}
}
