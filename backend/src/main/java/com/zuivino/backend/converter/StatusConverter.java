package com.zuivino.backend.converter;

import com.zuivino.backend.entity.Restaurant.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String>{
    
    @Override
    public String convertToDatabaseColumn(Status status) {
        return switch (status) {
            case Operational -> "Operational";
            case Temporarily_Closed -> "Temporarily Closed";
            case Permanently_Closed -> "Permanently Closed";
        };
    }

    @Override
    public Status convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "Operational" -> Status.Operational;
            case "Temporarily Closed" -> Status.Temporarily_Closed;
            case "Permanently Closed" -> Status.Permanently_Closed;
            default -> throw new IllegalArgumentException("Unknown status: " + dbData);
        };
    }
}
