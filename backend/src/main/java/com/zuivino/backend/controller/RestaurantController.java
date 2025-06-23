package com.zuivino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zuivino.backend.entity.Restaurant;
import com.zuivino.backend.repository.RestaurantRepository;

@Controller
@RequestMapping(path="/restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
