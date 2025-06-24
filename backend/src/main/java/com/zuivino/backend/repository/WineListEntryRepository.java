package com.zuivino.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.zuivino.backend.entity.WineListEntry;

public interface WineListEntryRepository extends CrudRepository<WineListEntry, Integer>{
    
}
