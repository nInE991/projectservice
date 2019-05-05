package com.example.projectservice.service;

import com.example.projectservice.entity.Roles;
import com.example.projectservice.repository.RolesRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RolesService {
	@Inject
	RolesRepository rolesRepository;

	public List<Roles> getList() {
		return rolesRepository.findAll();
	}
}
