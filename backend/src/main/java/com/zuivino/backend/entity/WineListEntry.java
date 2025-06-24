package com.zuivino.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WineListEntry {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer wineListEntryId;

    @Column(precision = 10, scale = 2)
    private BigDecimal bottlePrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal glassPrice;

    @ManyToOne
    @JoinColumn(name="winelist_id", nullable=false)
    private WineList wineList;

    @ManyToOne
    @JoinColumn(name="wine_id", nullable=false)
    private Wine wine;

    public Integer getWineListEntryId() {
        return this.wineListEntryId;
    }

    public void setWineListEntryId(Integer wineListEntryId) {
        this.wineListEntryId = wineListEntryId;
    }

    public BigDecimal getBottlePrice() {
        return this.bottlePrice;
    }

    public void setBottlePrice(BigDecimal bottlePrice) {
        this.bottlePrice = bottlePrice;
    }

    public BigDecimal getGlassPrice() {
        return this.glassPrice;
    }

    public void setGlassPrice(BigDecimal glassPrice) {
        this.glassPrice = glassPrice;
    }

    public WineList getWineList() {
        return this.wineList;
    }

    public void setWineList(WineList wineList) {
        this.wineList = wineList;
    }

    public Wine getWine() {
        return this.wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }
}
