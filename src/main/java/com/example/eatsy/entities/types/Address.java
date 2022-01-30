package com.example.eatsy.entities.types;

public class Address {
    public long longitude;
    public long latitude;
    public String details;

    public Address(long longitude, long latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Address(long longitude, long latitude, String details) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.details = details;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
