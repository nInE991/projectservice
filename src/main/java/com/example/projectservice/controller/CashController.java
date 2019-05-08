package com.example.projectservice.controller;

import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/manager/cash")
public class CashController {
	@Inject
	OrdersRepository ordersRepository;
	@Inject
	OrdersService ordersService;

	@GetMapping
	public String index(Model model) throws Exception {
		Map<Date, Double> date = ordersService.getListPrice();
		model.addAttribute("cashList", date);
		return "/manager/cash/index";
	}
}
