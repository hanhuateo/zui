package com.zuivino.backend.dto;

import lombok.Data;

@Data
public class winesDTO {
    private String wineType;
    private String winery;
    private String wineLabel;
    private String vintage;
    private String country;
    private String region;
    private String variety;
    private int bottleSize;
}
