package com.zuivino.backend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.zuivino.backend.converter.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "restaurants", uniqueConstraints = {
    @UniqueConstraint(name = "uk_restaurants", columnNames = {"name", "address"})
})
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Builder
    public Restaurant(String name, String websiteUrl, String cuisine, String region, String address, String addressUrl, Status status) {
        this.name = name;
        this.websiteUrl = websiteUrl;
        this.cuisine = cuisine;
        this.region = region;
        this.address = address;
        this.addressUrl = addressUrl;
        this.status = status;
    }
    
    // Columns 

    @Id
    @Column(name = "restaurant_id", nullable = false, updatable = false, length = 36)
    @Setter(AccessLevel.NONE)
    private String restaurantId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "website_url", nullable = false, length = 255)
    private String websiteUrl;

    @Column(nullable = false, length = 255)
    private String cuisine;

    @Column(nullable = false, length = 255)
    private String region;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(name = "address_url", nullable = false, length = 255)
    private String addressUrl;

    @Column(name = "added_timestamp", nullable = false)
    private LocalDateTime addedTimestamp;
    
    @Column(name = "updated_timestamp", nullable = false)
    private LocalDateTime updatedTimestamp;
    
    public enum Status {
        Operational,
        Temporarily_Closed,
        Permanently_Closed
    }
    
    @Convert(converter = StatusConverter.class)
    @Column(nullable = true)
    private Status status;

    @PrePersist
    public void prePersist() {
        if (this.restaurantId == null) {
            this.restaurantId = UUID.randomUUID().toString();
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
