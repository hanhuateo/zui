package com.zuivino.backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wines", uniqueConstraints = {
    @UniqueConstraint(name = "uk_wine", columnNames = {"wine_type", "winery", "wine_label", "vintage", "country", "region", "variety", "bottle_size"})
})
@Getter
@Setter
@NoArgsConstructor
public class Wines {

    @Builder
    public Wines(String wineType, String winery, String wineLabel, String vintage, String country, String region, String variety, int bottleSize) {
        this.wineType = wineType;
        this.winery = winery;
        this.wineLabel = wineLabel;
        this.vintage = vintage; 
        this.country = country;
        this.region = region;
        this.variety = variety;
        this.bottleSize = bottleSize;
    }
    
    @Id
    @Column(name = "wine_id", nullable = false, updatable = false, length = 36)
    @Setter(AccessLevel.NONE)
    private String wineId;

    @Column(name = "wine_type", nullable = false, length = 255)
    private String wineType;

    @Column(nullable = false, length = 255)
    private String winery;

    @Column(name = "wine_label", nullable = false, length = 255)
    private String wineLabel;

    @Column(nullable = false, length = 255)
    private String vintage;

    @Column(nullable = false, length = 255)
    private String country;

    @Column(nullable = false, length = 255)
    private String region;

    @Column(nullable = true, length = 255)
    private String variety;

    @Column(name = "bottle_size", nullable = false)
    private int bottleSize;

    @Column(name = "added_timestamp", nullable = false)
    private LocalDateTime addedTimestamp;
    
    @Column(name = "updated_timestamp", nullable = false)
    private LocalDateTime updatedTimestamp;

    @PrePersist
    public void prePersist() {
        if (this.wineId == null) {
            this.wineId = UUID.randomUUID().toString();
        }

        LocalDateTime now = LocalDateTime.now();
        if (this.addedTimestamp == null) {
            this.addedTimestamp = now;
        }
        if (this.updatedTimestamp == null) {
            this.updatedTimestamp = now;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedTimestamp = LocalDateTime.now();
    }
}
