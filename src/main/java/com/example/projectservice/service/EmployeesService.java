package com.example.projectservice.service;

import com.example.projectservice.entity.Employees;
import com.example.projectservice.entity.Roles;
import com.example.projectservice.entity.Users;
import com.example.projectservice.repository.EmployeesRepository;
import com.example.projectservice.repository.RolesRepository;
import com.example.projectservice.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeesService {
	@Inject
	EmployeesRepository employeesRepository;
	@Inject
	UsersRepository usersRepository;
	@Inject
	RolesRepository rolesRepository;
	public List<Employees> getEmployeesList() {
		return employeesRepository.findAll();
	}

	@Transactional
	public void Save(Employees employees, Users users, Integer roles) {


		Roles role = new Roles();
		role.setUsername(users.getUsername());
		switch (roles) {
			case 0:
				role.setRole("ROLE_Admin");
				users.setPosition("Администратор");
				break;
			case 1:
				role.setRole("ROLE_Director");
				users.setPosition("Директор");
				break;
			case 2:
				role.setRole("ROLE_Manager");
				users.setPosition("Менеджер");
				break;
			case 3:
				role.setRole("ROLE_Employees");
				users.setPosition("Сотрудник ремонта");
				break;
		}
		Users user = usersRepository.save(users);
		employees.setUsers(user);
		employeesRepository.save(employees);
		role.setUsers(users);
		rolesRepository.save(role);
	}

	@Transactional
	public void DeleteEmployees(Integer id) {
		Employees employees = employeesRepository.getOne(id);
		employeesRepository.delete(employees);
		usersRepository.delete(employees.getUsers());
	}
}