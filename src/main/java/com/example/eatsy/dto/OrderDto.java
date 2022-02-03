package com.example.eatsy.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderDto {
    private long userId;
    private long restaurantId;
    private String status;
    private AddressDto address;
    private List<MenuItemDto> menuItems;
}