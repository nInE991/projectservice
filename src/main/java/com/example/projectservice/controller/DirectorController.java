package com.example.projectservice.controller;

import com.example.projectservice.entity.Price;
import com.example.projectservice.repository.PriceRepository;
import com.example.projectservice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/director")
public class DirectorController {
	@Inject
	OrdersService ordersService;
	@Inject
	PriceRepository priceRepository;
	@GetMapping("/orders/day")
	public String getOrdersDay(Model model) {
		model.addAttribute("doneList", ordersService.getDoneList());
		return "/director/reports/orders/day";
	}

	@GetMapping("/orders/week")
	public String getWeek(Model model) {
		var d = ordersService.getDoneWeekList().stream().collect(Collectors.toMap(o -> (((Double) o.get(0)).intValue()) + " неделя, " + ((Double) o.get(1)).intValue() + ".г"
				, o -> o.get(2)));
		model.addAttribute("doneList", d);
		return "/director/reports/orders/week";
	}

	@GetMapping("/orders/month")
	public String getMouth(Model model) {
		var d = ordersService.getDoneMonthList().stream().collect(Collectors.toMap(o -> (((Double) o.get(0)).intValue()) + " месяц, " + ((Double) o.get(1)).intValue() + ".г"
				, o -> o.get(2)));
		model.addAttribute("doneList", d);
		return "/director/reports/orders/month";
	}

	@GetMapping("/cash/week")
	public String getCashWeek(Model model) {
		var d = ordersService.getCashWeekList().stream().collect(Collectors.toMap((o -> (((Double) o.get(0)).intValue())
				+ " Неделя, " + ((Double) o.get(1)).intValue() + ".г"), o -> ((Float) o.get(2)).doubleValue()));
		model.addAttribute("cashList", d);
		return "/director/reports/profits/week";
	}

	@GetMapping("/cash/month")
	public String getCashMonth(Model model) {
		model.addAttribute("cashList", ordersService.getCashMonthList());
		return "/director/reports/profits/month";
	}

	@GetMapping("/cash/day")
	public String getCashDay(Model model) {
		Map<Date, Double> date = ordersService.getListPrice();
		model.addAttribute("cashList", date);
		return "/director/reports/profits/day";
	}

	@GetMapping("/prices")
	public String getPrices(Model model) {
		model.addAttribute("priceList", priceRepository.findAll().stream().sorted(Comparator.comparing(Price::getName)).collect(Collectors.toList()));
		return "/director/priceList/index";
	}

	@GetMapping("/prices/{id}")
	public String getUserForEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("prices", priceRepository.getOne(id));
		return "/director/priceList/edit";
	}

	@PostMapping("/prices/{id}")
	public ResponseEntity editPrices(@PathVariable Integer id, @RequestParam("name") String name,
									 @RequestParam("price") Float price) {
		Price editPrice = priceRepository.getOne(id);
		editPrice.setName(name);
		editPrice.setPrice(price);
		priceRepository.save(editPrice);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/prices/add")
	public String getAdd() {
		return "/director/priceList/add";
	}

	@PostMapping("/prices/add")
	public ResponseEntity addPrice(@RequestParam("name") String name,
								   @RequestParam("price") Float price) {
		Price addPrice = new Price();
		addPrice.setName(name);
		addPrice.setPrice(price);
		priceRepository.save(addPrice);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/prices/{id}")
	public ResponseEntity deletePrice(@PathVariable Integer id) {
		priceRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
