package com.example.demo.repositories;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositroy extends CrudRepository<Customer, Integer> {
}
