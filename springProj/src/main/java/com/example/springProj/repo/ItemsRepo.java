package com.example.springProj.repo;

import com.example.springProj.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepo extends CrudRepository<Item,Long> {

}
