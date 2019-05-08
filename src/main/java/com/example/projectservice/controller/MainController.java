package com.example.projectservice.controller;

import com.example.projectservice.entity.Price;
import com.example.projectservice.repository.OrdersLogRepository;
import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.repository.PriceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class MainController {
	@Inject
	PriceRepository priceRepository;
	@Inject
	OrdersLogRepository ordersLogRepository;
	@Inject
	OrdersRepository ordersRepository;

	@GetMapping("/pricelist")
	public String getCustomers(Model model) {
		model.addAttribute("priceList", priceRepository.findAll().stream()
				.sorted(Comparator.comparing(Price::getName)).collect(Collectors.toList()));
		return "/pricelist";
	}

	@PostMapping("/track")
	public String getOrderHistory(@RequestParam("order") Integer id, Model model) {
		var orders = ordersRepository.getOne(id);
		model.addAttribute("orderHistory", ordersLogRepository.findByOrders(orders));
		return "/trackingSearch";
	}
}
