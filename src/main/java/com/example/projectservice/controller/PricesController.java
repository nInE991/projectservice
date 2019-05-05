package com.example.projectservice.controller;

import com.example.projectservice.entity.Price;
import com.example.projectservice.repository.PriceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/prices")
public class PricesController {
	@Inject
	PriceRepository priceRepository;

	@GetMapping()
	public String getPrices(Model model) {
		model.addAttribute("priceList", priceRepository.findAll().stream().sorted(Comparator.comparing(Price::getName)).collect(Collectors.toList()));
		return "/admin/priceList/index";
	}

	@GetMapping("{id}")
	public String getUserForEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("prices", priceRepository.getOne(id));
		return "/admin/priceList/edit/index";
	}

	@PostMapping("/{id}")
	public ResponseEntity editPrices(@PathVariable Integer id, @RequestParam("name") String name,
									 @RequestParam("price") Float price) {
		Price editPrice = priceRepository.getOne(id);
		editPrice.setName(name);
		editPrice.setPrice(price);
		priceRepository.save(editPrice);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/add")
	public String getAdd() {
		return "/admin/priceList/add/index";
	}

	@PostMapping("/add")
	public ResponseEntity addPrice(@RequestParam("name") String name,
								   @RequestParam("price") Float price) {
		Price addPrice = new Price();
		addPrice.setName(name);
		addPrice.setPrice(price);
		priceRepository.save(addPrice);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletePrice(@PathVariable Integer id) {
		priceRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
