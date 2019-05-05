package com.example.projectservice.controller;

import com.example.projectservice.entity.Customer;
import com.example.projectservice.repository.CustomersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/manager/customer")
public class CustomersController {
	@Inject
	CustomersRepository customersRepository;

	@GetMapping()
	public String index(Model model) {
		model.addAttribute("customerList", customersRepository.findAll());
		return "/manager/customer/index";
	}

	@GetMapping("/add")
	public String addIndex() {
		return "/manager/customer/add";
	}

	@PostMapping("/add")
	public ResponseEntity add(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("telephone") String telephone) {
		var customer = new Customer();
		customer.setName(name);
		customer.setLastname(lastName);
		customer.setTelephone(telephone);
		customersRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public String editIndex(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", customersRepository.getOne(id));
		return "manager/customer/edit";
	}

	@PostMapping("/{id}")
	public ResponseEntity edit(@PathVariable Integer id, @RequestParam("lastName") String lastName, @RequestParam("name") String name, @RequestParam("telephone") String telephone) {
		var customer = customersRepository.getOne(id);
		customer.setName(name);
		customer.setLastname(lastName);
		customer.setTelephone(telephone);
		customersRepository.save(customer);
		return ResponseEntity.ok().build();
	}
}
