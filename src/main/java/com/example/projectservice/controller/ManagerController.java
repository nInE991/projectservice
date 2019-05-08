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
}
