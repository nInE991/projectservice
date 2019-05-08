package com.example.projectservice.controller;

import com.example.projectservice.entity.Customer;
import com.example.projectservice.entity.Orders;
import com.example.projectservice.repository.CustomersRepository;
import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.repository.PriceRepository;
import com.example.projectservice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Inject
	CustomersRepository customersRepository;
	@Inject
	PriceRepository priceRepository;
	@Inject
	OrdersService ordersService;
	@Inject
	OrdersRepository ordersRepository;

	@GetMapping("/cash")
	public String getCash(Model model) {
		Map<Date, Double> date = ordersService.getListPrice();
		model.addAttribute("cashList", date);
		return "/manager/cash/index";
	}

	@GetMapping("/customer")
	public String getCustomer(Model model) {
		model.addAttribute("customerList", customersRepository.findAll());
		return "/manager/customer/index";
	}

	@GetMapping("/customer/add")
	public String getAddCustomer() {
		return "/manager/customer/add";
	}

	@PostMapping("/customer/add")
	public ResponseEntity addCustomer(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("telephone") String telephone) {
		var customer = new Customer();
		customer.setName(name);
		customer.setLastname(lastName);
		customer.setTelephone(telephone);
		customersRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/customer/{id}")
	public String getEditCustomer(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", customersRepository.getOne(id));
		return "manager/customer/edit";
	}

	@PostMapping("/customer/{id}")
	public ResponseEntity editCustomer(@PathVariable Integer id, @RequestParam("lastName") String lastName, @RequestParam("name") String name, @RequestParam("telephone") String telephone) {
		var customer = customersRepository.getOne(id);
		customer.setName(name);
		customer.setLastname(lastName);
		customer.setTelephone(telephone);
		customersRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/orders")
	public String getOrders(Model model) {
		model.addAttribute("acceptedList", ordersService.getListAccepted());
		model.addAttribute("waitList", ordersService.getListWait());
		model.addAttribute("performList", ordersService.getListPerform());
		model.addAttribute("doneList", ordersService.getListDone());
		model.addAttribute("cancelList", ordersService.getListCancel());
		model.addAttribute("finishList", ordersService.getListFinish());
		return "/manager/orders/index";
	}

	@GetMapping("/orders/add")
	public String getAddOrder(Model model) {
		model.addAttribute("customerList", customersRepository.findAll());
		model.addAttribute("priceList", priceRepository.findAll());
		return "manager/orders/add/index";
	}

	@PostMapping("/orders/add")
	public ResponseEntity addOrder(@RequestParam("serial") String serial, @RequestParam("customers") Integer customer,
								   @RequestParam("price") Integer id, @RequestParam("note") String note) {
		try {
			var order = new Orders();
			order.setSerial(serial);
			order.setCustomer(customersRepository.getOne(customer));
			order.setPrice(priceRepository.getOne(id));
			order.setNote(note);
			order.setDate(new Date());
			ordersService.saveNew(order);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@GetMapping("/orders/{id}")
	public String getOrder(@PathVariable Integer id, Model model) {
		model.addAttribute("order", ordersRepository.getOne(id));
		return "/manager/orders/edit/index";
	}

	@PostMapping("/orders/{id}")
	public ResponseEntity editOrder(@PathVariable Integer id, @RequestParam("status") Integer status) {
		var order = ordersRepository.getOne(id);
		switch (status) {
			case 1:
				ordersService.wait(order);
				break;
			case 2:
				ordersService.cancel(order);
				break;
			case 3:
				ordersService.finish(order);
				break;
		}
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/orders/{id}")
	public ResponseEntity deleteOrder(@PathVariable Integer id) {
		var order = ordersRepository.getOne(id);
		ordersService.delete(order);
		return ResponseEntity.ok().build();
	}
}
