package com.example.eatsy.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDto {
    private double longitude;
    private double latitude;
    private String address;
}
