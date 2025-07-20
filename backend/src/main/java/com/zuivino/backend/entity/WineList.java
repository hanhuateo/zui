package com.zuivino.backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "winelists", uniqueConstraints = {
    @UniqueConstraint(name = "uk_winelist", columnNames = {"winelist_name"})
})
@Getter
@Setter
@NoArgsConstructor
public class WineList {

    @Builder
    public WineList(String wineListName, Restaurant restaurant) {
        this.wineListName = wineListName;
        this.restaurant = restaurant;
    }

    // Columns
    
    @Id
    @Column(name = "winelist_id", nullable = false, updatable = false, length = 36)
    @Setter(AccessLevel.NONE)
    private String wineListId;

    @Column(name = "winelist_name", nullable = false, length = 255)
    private String wineListName;

    @Column(name = "added_timestamp", nullable = false)
    private LocalDateTime addedTimestamp;

    @Column(name = "updated_timestamp", nullable = false)
    private LocalDateTime updatedTimestamp;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id", nullable=false, foreignKey = @ForeignKey(name = "fk_winelists_restaurant"))
    private Restaurant restaurant;

    @PrePersist
    public void prePersist() {
        if (this.wineListId == null) {
            this.wineListId = UUID.randomUUID().toString();
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
