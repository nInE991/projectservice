package com.example.projectservice.service;

import com.example.projectservice.entity.Orders;
import com.example.projectservice.entity.OrdersLog;
import com.example.projectservice.entity.OrdersStatus;
import com.example.projectservice.repository.OrdersCustomRepository;
import com.example.projectservice.repository.OrdersLogRepository;
import com.example.projectservice.repository.OrdersRepository;
import com.example.projectservice.repository.OrdersStatusRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrdersService {
	@Inject
	OrdersRepository ordersRepository;
	@Inject
	OrdersLogRepository ordersLogRepository;
	@Inject
	OrdersStatusRepository statusRepository;
	@Inject
	EntityManager entityManager;
	@Inject
	OrdersCustomRepository ordersCustomRepository;
	public List<Orders> getListAccepted() {
		OrdersStatus ordersStatus = statusRepository.getOne(1);
		return ordersRepository.findByStatusAndFinish(ordersStatus, false);
	}

	public List<Orders> getListWait() {
		OrdersStatus ordersStatus = statusRepository.getOne(2);
		return ordersRepository.findByStatusAndFinish(ordersStatus, false);
	}

	public List<Orders> getListPerform() {
		OrdersStatus ordersStatus = statusRepository.getOne(3);
		return ordersRepository.findByStatusAndFinish(ordersStatus, false);
	}

	public List<Orders> getListDone() {
		OrdersStatus ordersStatus = statusRepository.getOne(4);
		return ordersRepository.findByStatusAndFinish(ordersStatus, false);
	}

	public List<Orders> getListCancel() {
		OrdersStatus ordersStatus = statusRepository.getOne(5);
		return ordersRepository.findByStatusAndFinish(ordersStatus, false);
	}

	public List<Orders> getListFinish() {
		return ordersRepository.findByFinishIsTrue();
	}

	@Transactional
	public Orders saveNew(Orders orders) {
		var status = statusRepository.getOne(1);
		orders.setStatus(status);
		orders.setFinish(false);
		Orders service = ordersRepository.save(orders);
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ принят менеджером"));
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ ожидает передачу в отдел ремонта"));
		return service;
	}

	@Transactional
	public Orders wait(Orders orders) {
		var status = statusRepository.getOne(2);
		orders.setStatus(status);
		Orders service = ordersRepository.save(orders);
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ передан в отдел ремонта"));
		return orders;
	}

	@Transactional
	public Orders perform(Orders orders) {
		var status = statusRepository.getOne(3);
		orders.setStatus(status);
		Orders service = ordersRepository.save(orders);
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Специалист начал ремонт"));
		return orders;
	}

	@Transactional
	public Orders done(Orders orders) {
		var status = statusRepository.getOne(4);
		orders.setStatus(status);
		Orders service = ordersRepository.save(orders);
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ выполнен"));
		return orders;
	}

	@Transactional
	public Orders cancel(Orders orders) {
		var status = statusRepository.getOne(5);
		orders.setStatus(status);
		Orders service = ordersRepository.save(orders);
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ отменен"));
		return orders;
	}

	@Transactional
	public Orders finish(Orders orders) {
		orders.setFinish(true);
		orders.setEndDate(new Date());
		Orders service = ordersRepository.save(orders);
		if (service.getStatus().getId() != 4) {
			ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ оплачен"));
		}
		ordersLogRepository.save(new OrdersLog(new Date(), service, "Заказ выдан получателю"));
		return orders;
	}

	@Transactional
	public Orders delete(Orders orders) {
		ordersLogRepository.deleteByOrders(orders);
		ordersRepository.delete(orders);
		return orders;
	}

	@Transactional
	public Map<Date, Double> getListPrice() {
		return ordersRepository.findByStatusAndFinish(statusRepository.getOne(4), true).stream()
				.collect(Collectors.groupingBy(o -> o.getEndDate(),
						Collectors.summingDouble(o -> o.getPrice().getPrice().doubleValue())));
	}

	public Map<Date, Long> getDoneList() {
		return ordersRepository.findByStatusAndFinish(statusRepository.getOne(4), true).stream().collect(Collectors.groupingBy(o -> o.getEndDate(),
				Collectors.counting()));
	}

	public List<Tuple> getDoneWeekList() {
		return entityManager.createNativeQuery("select date_part('week', end_date) as week,date_part('year', end_date) as year,count(status_id) " +
				"from orders where finish=true and status_id=4 group by end_date", Tuple.class).getResultList();
	}

	public List<Tuple> getDoneMonthList() {
		return entityManager.createNativeQuery("select date_part('month', end_date) as week,date_part('year', end_date) as year,count(status_id) " +
				"from orders where finish=true and status_id=4 group by end_date", Tuple.class).getResultList();
	}

	public List<Tuple> getCashWeekList() {
		return ordersCustomRepository.CashWeekList();
	}

	public Map<String, Double> getCashMonthList() {
		return ordersCustomRepository.CashMonthList().stream().collect(Collectors.toMap((o -> (((Double) o.get(0)).intValue()) + " месяц, " + ((Double) o.get(1)).intValue() + ".г"), o -> ((Float) o.get(2)).doubleValue()));
	}
}
