package com.example.beebookinghotel.mapper;

import com.example.beebookinghotel.entity.Amenities;
import com.example.beebookinghotel.model.dto.AmenitiesDto;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AmenitiesMapper implements Function<Amenities, AmenitiesDto> {
    @Override
    public AmenitiesDto apply(Amenities amenities) {
        return  AmenitiesDto.builder()
                .id(amenities.getId())
                .name(amenities.getName())
                .build();
    }
}
