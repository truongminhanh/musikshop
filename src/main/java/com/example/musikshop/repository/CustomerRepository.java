package com.example.musikshop.repository;

import com.example.musikshop.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Optional<Customer> findbyEmail(String email);
}
