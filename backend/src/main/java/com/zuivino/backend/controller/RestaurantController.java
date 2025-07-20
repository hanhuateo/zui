package com.zuivino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zuivino.backend.dto.RestaurantDTO;
import com.zuivino.backend.entity.Restaurant;
import com.zuivino.backend.repository.RestaurantRepository;





@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(path="/all")
    public Iterable<Restaurant> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @GetMapping(path="/count")
    public long getNumberOfRestaurants() {
        return this.restaurantRepository.count();
    }

    @GetMapping(path="/one")
    public Restaurant getRestaurant(@RequestParam String name, String address) {
        return this.restaurantRepository.findByNameAndAddress(name, address);
    }
    
    @PostMapping(path="/add")
    public String addRestaurant(@RequestBody RestaurantDTO dto) {

        Restaurant restaurant = Restaurant.builder()
            .name(dto.getName())
            .websiteUrl(dto.getWebsiteUrl())
            .cuisine(dto.getCuisine())
            .region(dto.getRegion())
            .address(dto.getAddress())
            .addressUrl(dto.getAddressUrl())
            .status(dto.getStatus())
            .build();
        
        restaurantRepository.save(restaurant);

        return String.format("Restaurant created : %s", restaurant.getName());
    }
    
}
