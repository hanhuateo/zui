package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
    
}
