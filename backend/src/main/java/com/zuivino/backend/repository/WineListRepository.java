package com.zuivino.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zuivino.backend.entity.WineList;

public interface  WineListRepository extends CrudRepository<WineList, String>{
    
    @Query(value = "SELECT * FROM winelists WHERE restaurant_id = :restaurantId", nativeQuery = true) 
    Iterable<WineList> findByRestaurantId(@Param("restaurantId") String restaurantId);
}
