package com.example.projectservice.service;

import com.example.projectservice.entity.Employees;
import com.example.projectservice.entity.Users;
import com.example.projectservice.repository.EmployeesRepository;
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

	public List<Employees> getEmployeesList() {
		return employeesRepository.findAll();
	}

	@Transactional
	public void Save(Employees employees, Users users) {
		Users user = usersRepository.save(users);
		employees.setUsers(user);
		Employees emp = employeesRepository.save(employees);
	}

	@Transactional
	public void DeleteEmployees(Integer id) {
		Employees employees = employeesRepository.getOne(id);
		employeesRepository.delete(employees);
		usersRepository.delete(employees.getUsers());
	}
}