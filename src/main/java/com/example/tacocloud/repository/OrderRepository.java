package com.example.tacocloud.repository;

import com.example.tacocloud.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository
        extends CrudRepository<TacoOrder, String> {

}