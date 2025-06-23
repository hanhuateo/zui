package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.Restaurants;

public interface RestaurantsRepository extends CrudRepository<Restaurants, Integer>{
    
}
