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
public class Wine {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer wineId;

    private String wineType;

    private String winery;

    private String wineLabel;

    private String vintage;

    private String country;

    private String region;

    private String variety;

    private Integer bottleSize;

    private LocalDateTime addedTimestamp;

    private LocalDateTime updatedTimestamp;

    @OneToMany(mappedBy = "restaurant_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineListEntry> listOfWineListEntry = new ArrayList<>();

    public Integer getWineId() {
        return this.wineId;
    }

    public void setWineId(Integer wineId) {
        this.wineId = wineId;
    }

    public String getWineType() {
        return this.wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }

    public String getWinery() {
        return this.winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getWineLabel() {
        return this.wineLabel;
    }

    public void setWineLabel(String wineLabel) {
        this.wineLabel = wineLabel;
    }

    public String getVintage() {
        return this.vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVariety() {
        return this.variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Integer getBottleSize() {
        return this.bottleSize;
    }

    public void setBottleSize(Integer bottleSize) {
        this.bottleSize = bottleSize;
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

    public List<WineListEntry> getListOfWineListEntry() {
        return this.listOfWineListEntry;
    }

    public void setListOfWineListEntry(List<WineListEntry> listOfWineListEntry) {
        this.listOfWineListEntry = listOfWineListEntry;
    }

    public void addWineListEntry(WineListEntry wineListEntry) {
        this.listOfWineListEntry.add(wineListEntry);
        wineListEntry.setWine(this);
    }

    public void removeWineListEntry(WineListEntry wineListEntry) {
        this.listOfWineListEntry.remove(wineListEntry);
        wineListEntry.setWine(null);
    }
}
