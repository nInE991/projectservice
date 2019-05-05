package com.example.projectservice.repository;

import com.example.projectservice.entity.Orders;
import com.example.projectservice.entity.OrdersLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersLogRepository extends JpaRepository<OrdersLog, Integer> {
	void deleteByOrders(Orders orders);

	List<OrdersLog> findByOrders(Orders orders);
}
