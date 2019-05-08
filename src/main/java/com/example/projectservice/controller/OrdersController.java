package com.example.projectservice.controller;

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

@Controller
@RequestMapping("/manager/orders")
public class OrdersController {
	@Inject
	OrdersService ordersService;
	@Inject
	CustomersRepository customersRepository;
	@Inject
	PriceRepository priceRepository;
	@Inject
	OrdersRepository ordersRepository;

	@GetMapping
	public String get(Model model) {
		model.addAttribute("acceptedList", ordersService.getListAccepted());
		model.addAttribute("waitList", ordersService.getListWait());
		model.addAttribute("performList", ordersService.getListPerform());
		model.addAttribute("doneList", ordersService.getListDone());
		model.addAttribute("cancelList", ordersService.getListCancel());
		model.addAttribute("finishList", ordersService.getListFinish());
		return "/manager/orders/index";
	}

	@GetMapping("/add")
	public String getAdd(Model model) {
		model.addAttribute("customerList", customersRepository.findAll());
		model.addAttribute("priceList", priceRepository.findAll());
		return "manager/orders/add/index";
	}

	@PostMapping("/add")
	public ResponseEntity add(@RequestParam("serial") String serial, @RequestParam("customers") Integer customer,
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

	@GetMapping("/{id}")
	public String getOrder(@PathVariable Integer id, Model model) {
		model.addAttribute("order", ordersRepository.getOne(id));
		return "/manager/orders/edit/index";
	}

	@PostMapping("/{id}")
	public ResponseEntity edit(@PathVariable Integer id, @RequestParam("status") Integer status) {
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

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		var order = ordersRepository.getOne(id);
		ordersService.delete(order);
		return ResponseEntity.ok().build();
	}

}
