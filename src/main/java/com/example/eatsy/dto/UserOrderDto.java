package com.example.eatsy.dto;

import com.example.eatsy.entities.types.OrderStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class UserOrderDto {
    private long id;
    private long userId;
    private long restaurantId;
    private OrderStatus status;
    private AddressDto address;
    private List<UserOrderItemDto> orderItems;
    private Double total;
}