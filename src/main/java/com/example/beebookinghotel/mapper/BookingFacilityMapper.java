package com.example.beebookinghotel.mapper;


import com.example.beebookinghotel.entity.BookingFacility;
import com.example.beebookinghotel.model.dto.BookingFacilityDto;

import java.util.function.Function;

public class BookingFacilityMapper implements Function<BookingFacility, BookingFacilityDto> {

    @Override
    public BookingFacilityDto apply(BookingFacility bookingFacility) {
        return BookingFacilityDto.builder()
                .id(bookingFacility.getId())
                .createAt(bookingFacility.getCreateAt())
                .totalPrice(bookingFacility.getTotalPrice())
                .bookingId(bookingFacility.getId())
                .facilityId(bookingFacility.getId())
                .build();
    }
}
