package com.example.projectservice.controller;

import com.example.projectservice.repository.CustomersRepository;
import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.repository.PriceRepository;
import com.example.projectservice.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Inject
	CustomersRepository customersRepository;
	@Inject
	OrdersRepository orders;
	@Inject
	PriceRepository priceRepository;
	@Inject
	OrdersService service;

	@GetMapping()
	public String index() {
		return "/manager/index";
	}
	/*
	@GetMapping("/customers")
	public String getCustomers(Model model) {
		model.addAttribute("customersList", customersRepository.findAll());
		return "/manager/customers";
	}

	@GetMapping("/customers/add")
	public String getAddCustomers() {
		return "/manager/addCustomers";
	}


	@GetMapping("/customers/{id}")
	public String getAddCustomers(@PathVariable Integer id, Model model) {
		model.addAttribute("customers", customersRepository.getOne(id));
		return "/manager/editCustomers";
	}

	@PostMapping("/customers/add")
	public ResponseEntity addCustomers(@RequestParam("name") String name, @RequestParam("telephone") String telephone) {
		var customers = new Customer();
		customers.setName(name);
		customers.setTelephone(telephone);
		customersRepository.save(customers);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/customers/{id}")
	public ResponseEntity editCustomers(@PathVariable Integer id, @RequestParam("name") String name,
										@RequestParam("telephone") String telephone) {
		var customers = customersRepository.getOne(id);
		customers.setName(name);
		customers.setTelephone(telephone);
		customersRepository.save(customers);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/customers/searchByName")
	public String searchCustomersByName(@RequestParam("name") String name, Model model) {
		model.addAttribute("searchList", customersRepository.findByNameContaining(name));
		return "/manager/searchCustomer";
	}

	@PostMapping("/customers/searchByTelephone")
	public String searchCustomersByTelephone(@RequestParam("telephone") String telephone, Model model) {
		model.addAttribute("searchList", customersRepository.findByTelephoneContaining(telephone));
		return "/manager/searchCustomer";
	}

	@GetMapping("/service")
	public String getService(Model model) {
		model.addAttribute("serviceList", servicesRepository.findAll().stream().sorted(Comparator.comparing(Orders::getDate)).collect(Collectors.toList()));
		return "/manager/service";
	}

	@GetMapping("/service/add")
	public String getAddService(Model model) {
		model.addAttribute("customersList", customersRepository.findAll().stream().sorted(Comparator.comparing(Customer::getName)).collect(Collectors.toList()));
		model.addAttribute("pricesList", priceRepository.findAll());
		return "/manager/addService";
	}

	@PostMapping("/service/add")
	public ResponseEntity addService(@RequestParam("serial") String serial, @RequestParam("customers") Integer customers,
									 @RequestParam("price") Integer id, @RequestParam("note") String note) {
		var services = new Orders();
		services.setDate(new Date());
		services.setSerial(serial);
		services.setNote(note);
		services.setCustomers(customersRepository.getOne(customers));
		services.setPrice(priceRepository.getOne(id));
		service.saveNew(services);
		return ResponseEntity.ok().build();
	}*/
}
