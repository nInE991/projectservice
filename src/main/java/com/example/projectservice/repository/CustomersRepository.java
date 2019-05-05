package com.example.projectservice.repository;

import com.example.projectservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByNameContaining(String name);

	List<Customer> findByTelephoneContaining(String telephone);
}
