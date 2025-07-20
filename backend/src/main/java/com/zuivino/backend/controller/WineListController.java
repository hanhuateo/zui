package com.zuivino.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zuivino.backend.dto.WineListDTO;
import com.zuivino.backend.entity.Restaurant;
import com.zuivino.backend.entity.WineList;
import com.zuivino.backend.repository.RestaurantRepository;
import com.zuivino.backend.repository.WineListRepository;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping(path = "/winelist")
public class WineListController {
    
    @Autowired
    private WineListRepository wineListRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping(path = "/all")
    public Iterable<WineList> getAllWineLists() {
        return wineListRepository.findAll();
    }

    @GetMapping(path = "/count")
    public long getNumberOfWineLists() {
        return wineListRepository.count();
    }

    @GetMapping(path = "/one")
    public String getWineListForRestaurant(@RequestBody WineListDTO dto) {
        
        Restaurant restaurant = restaurantRepository.findByNameAndAddress(dto.getRestaurantName(), dto.getRestaurantAddress());

         Iterable<WineList> listOfWineLists = wineListRepository.findByRestaurantId(restaurant.getRestaurantId());

         return listOfWineLists.toString();
    }
    

    @PostMapping(path="/add")
    @Transactional
    public String addWineList(@RequestBody WineListDTO dto) {

        Restaurant restaurant = restaurantRepository.findByNameAndAddress(dto.getRestaurantName(), dto.getRestaurantAddress());

        WineList wineList = WineList.builder()
                .wineListName(dto.getWineListName())
                .restaurant(restaurant)
                .build();

        wineListRepository.save(wineList);

        return String.format("WineList: %s added into %s", wineList.getWineListName(), restaurant.getName());
    }
    
}
