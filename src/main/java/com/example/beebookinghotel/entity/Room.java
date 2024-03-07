package com.example.beebookinghotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(1000)")
    private String name;

    @Column(columnDefinition = "nvarchar(2000)")
    private String description;

    private Double price;

    private Integer floor;

    private Integer capacity;

    private Integer acreage;

    private Integer quantityBed;

    private boolean isDelete;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RoomImage> roomImages;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RoomDiscount> roomDiscounts;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<RoomAmenities> roomAmenities;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public List<String> getImages(){
        return this.getRoomImages().stream().map(RoomImage::getImageUrl).toList();

    }

    public List<Amenities> getAllAmenities(){
        List<Amenities> list = new ArrayList<>();

        for (RoomAmenities roomAmenities : this.getRoomAmenities()){
            list.add(roomAmenities.getAmenities());
        }

        return list;
    }

}
