package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.WineList;

public interface  WineListRepository extends CrudRepository<WineList, Integer>{
    
}
