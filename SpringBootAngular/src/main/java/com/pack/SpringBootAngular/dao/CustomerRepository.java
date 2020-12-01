package com.pack.SpringBootAngular.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pack.SpringBootAngular.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByAge(int age);

}
