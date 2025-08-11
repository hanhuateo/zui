package com.zuivino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuivino.backend.dto.winesDTO;
import com.zuivino.backend.entity.Wines;
import com.zuivino.backend.repository.WinesRepository;



@RestController
@RequestMapping(path = "/wines")
public class WinesController {
    
    @Autowired
    private WinesRepository winesRepository;

    @GetMapping(path = "/all")
    public Iterable<Wines> getAllWines() {
        return winesRepository.findAll();
    }

    @GetMapping(path = "/count")
    public long getNumberOfWines() {
        return winesRepository.count();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Wines> addWine(@RequestBody winesDTO dto) {

        Wines wine = Wines.builder()
                .wineType(dto.getWineType())
                .winery(dto.getWinery())
                .wineLabel(dto.getWineLabel())
                .vintage(dto.getVintage())
                .country(dto.getCountry())
                .region(dto.getRegion())
                .variety(dto.getVariety())
                .bottleSize(dto.getBottleSize())
                .build();
        
        Wines saved = winesRepository.save(wine);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
