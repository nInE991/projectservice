package com.example.projectservice.repository;

import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.List;

@Repository
public class OrdersCustomRepository {
	@Inject
	EntityManager entityManager;

	public List<Tuple> CashWeekList() {
		return entityManager.createNativeQuery("select date_part('week', end_date)as week ,date_part('year', end_date) as year,sum(pr.price)" +
				"from orders inner join price as pr on orders.price_id = pr.id where finish=true and status_id=4  group by end_date", Tuple.class).getResultList();
	}

	public List<Tuple> CashMonthList() {
		return entityManager.createNativeQuery("select date_part('month', end_date)as week ,date_part('year', end_date) as year,sum(pr.price)" +
				"from orders inner join price as pr on orders.price_id = pr.id where finish=true and status_id=4  group by end_date", Tuple.class).getResultList();
	}
}
