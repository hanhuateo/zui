package com.zuivino.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zuivino.backend.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, String>{
    
    @Query(value = "SELECT * FROM restaurants WHERE name = :name AND address = :address", nativeQuery = true) 
    Restaurant findByNameAndAddress(@Param("name") String name, @Param("address") String address);
}
