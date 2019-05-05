package com.example.projectservice.controller;

import com.example.projectservice.entity.Employees;
import com.example.projectservice.entity.Users;
import com.example.projectservice.repository.EmployeesRepository;
import com.example.projectservice.repository.RolesRepository;
import com.example.projectservice.repository.UsersRepository;
import com.example.projectservice.service.EmployeesService;
import com.example.projectservice.service.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
	@Inject
	EmployeesService service;
	@Inject
	RolesService rolesService;
	@Inject
	RolesRepository rolesRepository;
	@Inject
	EmployeesRepository employeesRepository;
	@Inject
	UsersRepository usersRepository;

	@GetMapping()
	public String getUsers(Model model) {
		model.addAttribute("employeesList", employeesRepository.findAll());
		return "/admin/users/index";
	}

	@GetMapping("/{id}")
	public String getUserForEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("employees", employeesRepository.getOne(id));
		model.addAttribute("rolesList", rolesService.getList());
		return "/admin/users/edit/index";
	}

	@PostMapping("/{id}")
	public ResponseEntity editUser(@PathVariable Integer id,
								   @RequestParam("name") String name,
								   @RequestParam("lastName") String lastname,
								   @RequestParam("birthDate") String birthDate,
								   @RequestParam("telephone") String telephone,
								   @RequestParam("login") String login,
								   @RequestParam("password") String password,
								   @RequestParam("roles") Integer roles) throws ParseException {
		Employees employees = employeesRepository.getOne(id);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStr;
		dateStr = formatter.parse(birthDate);
		if (employees.getBirthDate().equals(dateStr)) {
			employees.setBirthDate(dateStr);
		}
		if (employees.getName().equals(name)) {
			employees.setName(name);
		}
		employees.setLastName(lastname);
		employees.setTelephone(telephone);
		Users users = usersRepository.getOne(employees.getUsers().getId());
		users.setUsername(login);
		if (users.getPassword().isEmpty()) {
			return ResponseEntity.status(403).build();
		}
		users.setPassword(password);
		users.setRole(rolesRepository.getOne(roles));
		service.Save(employees, users);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		service.DeleteEmployees(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/registration")
	public String registrationUser(Model model) {
		model.addAttribute("rolesList", rolesRepository.findAll());
		return "/admin/users/add/index";
	}

	@PostMapping("/registration")
	public ResponseEntity addEmployees(@RequestParam("name") String name, @RequestParam("lastName") String lastname,
									   @RequestParam("birthDate") String birthDate,
									   @RequestParam("telephone") String telephone,
									   @RequestParam("login") String login,
									   @RequestParam("password") String password,
									   @RequestParam("roles") Integer roles) throws ParseException {
		if (name.isEmpty() ||
				lastname.isEmpty() ||
				birthDate.isEmpty() ||
				telephone.isEmpty() ||
				login.isEmpty() ||
				password.isEmpty()) {
			return ResponseEntity.status(400).body("Не заполнены поля");
		}
		Employees employees = new Employees();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateStr;
		dateStr = formatter.parse(birthDate);
		employees.setBirthDate(dateStr);
		employees.setName(name);
		employees.setLastName(lastname);
		employees.setTelephone(telephone);
		Users users = new Users();
		users.setUsername(login);
		users.setPassword(password);
		users.setRole(rolesRepository.getOne(roles));
		service.Save(employees, users);
		return ResponseEntity.ok().build();
	}
}
