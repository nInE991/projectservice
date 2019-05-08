package com.example.projectservice.repository;

import com.example.projectservice.entity.Orders;
import com.example.projectservice.entity.OrdersStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	List<Orders> findByStatusAndFinish(OrdersStatus ordersStatus, Boolean bool);

	List<Orders> findByFinishIsTrue();
//	@Query(value = "select date_part('week', end_date) from orders o where o.status_id=4 and o.finish=true group by o.end_date",nativeQuery = true)
//	List<Orders> findfinishbyWeek();
}
