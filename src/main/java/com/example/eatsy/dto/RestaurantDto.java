package com.example.eatsy.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantDto {
    private String name;
    private AddressDto address;
    private String description;
    private String contact;
    private Integer openingTime;
    private Integer closingTime;
    private List<MenuItemDto> menuItems;
}
