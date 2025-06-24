package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.Wine;

public interface WineRepository extends CrudRepository<Wine, Integer>{
    
}
