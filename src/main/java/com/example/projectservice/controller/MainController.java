package com.example.projectservice.controller;

import com.example.projectservice.entity.Price;
import com.example.projectservice.repository.OrdersLogRepository;
import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.repository.PriceRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@GetMapping("/hello")
	public String login(Authentication authentication) {
		if (authentication.getAuthorities().toString().equals("[ROLE_Admin]")) {
			return "redirect:/admin";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Director]")) {
			return "redirect:/director";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Manager]")) {
			return "redirect:/manager";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Employees]")) {
			return "redirect:/employees";
		}
		return "index";
	}

	@GetMapping(value = "/username", produces = {"application/json"})
	@ResponseBody
	public String getUserName(Authentication authentication) {
		return authentication.getName();
	}

	@GetMapping("/accessDeny")
	public String accessDeny(Authentication authentication) {
		if (authentication.getAuthorities().toString().equals("[ROLE_Admin]")) {
			return "/admin/denyAccess";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Director]")) {
			return "/director/denyAccess";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Manager]")) {
			return "/manager/denyAccess";
		} else if (authentication.getAuthorities().toString().equals("[ROLE_Employees]")) {
			return "/employees/denyAccess";
		}
		return "access";
	}
}
