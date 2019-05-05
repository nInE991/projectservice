package com.example.projectservice.repository;

import com.example.projectservice.entity.OrdersStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersStatusRepository extends JpaRepository<OrdersStatus, Integer> {
}
