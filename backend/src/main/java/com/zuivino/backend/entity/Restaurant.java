package com.zuivino.backend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
    
    @Id
    @GeneratedValue
    (strategy=GenerationType.IDENTITY)
    private Integer restaurantId;

    private String name;

    private String websiteUrl;

    private String cuisine;

    private String region;

    private String address;

    private String addressUrl;

    private LocalDateTime addedTimestamp;

    private LocalDateTime updatedTimestamp;

    @OneToMany(mappedBy = "restaurant_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineList> listOfWineList = new ArrayList<>();

    public Integer getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressUrl() {
        return this.addressUrl;
    }

    public void setAddressUrl(String addressUrl) {
        this.addressUrl = addressUrl;
    }

    public LocalDateTime getAddedTimestamp() {
        return this.addedTimestamp;
    }

    public void setAddedTimestamp(LocalDateTime addedTimestamp) {
        this.addedTimestamp = addedTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp() {
        return this.updatedTimestamp;
    }

    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public List<WineList> getListOfWineList() {
        return this.listOfWineList;
    }

    public void setListOfWineList(List<WineList> listOfWineList) {
        this.listOfWineList = listOfWineList;
    }

    public void addWinelist(WineList wineList) {
        this.listOfWineList.add(wineList);
        wineList.setRestaurant(this); // maintain bidirectional link
    }

    public void removeWinelist(WineList wineList) {
        this.listOfWineList.remove(wineList);
        wineList.setRestaurant(null); // clear the relationship
    }
}
