package com.example.springProj.repo;

import com.example.springProj.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Long> {
    Customer findByLogin(String login);
}
