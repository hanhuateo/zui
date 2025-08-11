package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.Wines;

public interface WinesRepository extends CrudRepository<Wines, String> {
    
}
