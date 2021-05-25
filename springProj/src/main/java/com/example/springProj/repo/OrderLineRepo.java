package com.example.springProj.repo;

import com.example.springProj.models.Item;
import com.example.springProj.models.OrderLine;
import org.springframework.data.repository.CrudRepository;


public interface OrderLineRepo extends CrudRepository<OrderLine,Long> {
    OrderLine findByItem(Item item);
}
