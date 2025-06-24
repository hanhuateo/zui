package com.zuivino.backend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class WineList {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer wineListId;

    private String wineListName;

    private LocalDateTime addedTimestamp;

    private LocalDateTime updatedTimestamp;

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "winelist_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineListEntry> listOfWineListEntry = new ArrayList<>();

    public Integer getWineListId() {
        return this.wineListId;
    }

    public void setWineListId(Integer wineListId) {
        this.wineListId = wineListId;
    }

    public String getWineListName() {
        return this.wineListName;
    }

    public void setWineListName(String wineListName) {
        this.wineListName = wineListName;
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

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<WineListEntry> getListOfWineListEntry() {
        return this.listOfWineListEntry;
    }

    public void setListOfWineListEntry(List<WineListEntry> listOfWineListEntry) {
        this.listOfWineListEntry = listOfWineListEntry;
    }

    public void addWineListEntry(WineListEntry wineListEntry) {
        this.listOfWineListEntry.add(wineListEntry);
        wineListEntry.setWineList(this);
    }

    public void removeWineListEntry(WineListEntry wineListEntry) {
        this.listOfWineListEntry.remove(wineListEntry);
        wineListEntry.setWineList(null);
    }
}
