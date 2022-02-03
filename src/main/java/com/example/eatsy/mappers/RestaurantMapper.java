package com.example.eatsy.mappers;

import com.example.eatsy.dto.RestaurantDto;
import com.example.eatsy.entities.types.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
/*
@Mapper(componentModel = "spring")
public class RestaurantMapper {
    @Mappings({
            @Mapping(target="address", source = "venue.name")
    })
    RestaurantDto restaurantToRestaurantDto(Restaurant restaurant);//, Venue venue, EventSubCategory eventSubCategory, EventCategory eventCategory);

    @Mappings({
            @Mapping(target = "eventSubCategory.description", source = "eventSubCategory"),
            @Mapping(target = "eventCategory.description", source = "eventCategory"),
            @Mapping(target="startDatetime", source = "startDatetime", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="endDatetime", source = "endDatetime", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="ticketsOnSaleDate", source = "ticketsOnSaleDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="publishDate", source = "publishDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            @Mapping(target="artist.name", source = "artist"),
            @Mapping(target="venue.name", source = "venue"),

    })
    Event eventDtoToEvent(EventDto eventDto);
}
*/