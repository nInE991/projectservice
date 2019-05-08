package com.example.projectservice.controller;

import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	@Inject
	OrdersService ordersService;
	@Inject
	OrdersRepository ordersRepository;

	@GetMapping()
	public String index() {
		return "/employees/index";
	}

	@GetMapping("/orders")
	public String getOrders(Model model) {
		model.addAttribute("waitList", ordersService.getListWait());
		model.addAttribute("performList", ordersService.getListPerform());
		model.addAttribute("doneList", ordersService.getListDone());
		return "/employees/orders/index";
	}

	@GetMapping("/orders/{id}")
	public String getOrder(@PathVariable Integer id, Model model) {
		model.addAttribute("order", ordersRepository.getOne(id));
		return "/employees/orders/edit";
	}

	@PostMapping("/orders/{id}")
	public ResponseEntity edit(@PathVariable Integer id, @RequestParam("status") Integer status) {
		var order = ordersRepository.getOne(id);
		switch (status) {
			case 1:
				ordersService.perform(order);
				break;
			case 2:
				ordersService.done(order);
				break;
		}
		return ResponseEntity.ok().build();
	}

}
