package com.example.projectservice.controller;

import com.example.projectservice.service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/director")
public class DirectorController {
	@Inject
	OrdersService ordersService;

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
}
