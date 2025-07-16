package com.zuivino.backend.dto;

import com.zuivino.backend.entity.Restaurant.Status;

import lombok.Data;

@Data
public class RestaurantDTO {
    private String name;
    private String websiteUrl;
    private String cuisine;
    private String region;
    private String address;
    private String addressUrl;
    private Status status;
}