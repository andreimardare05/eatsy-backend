package entities.types;

import entities.types.Address;

public class Restaurant {
    private String name;
    private Address address;
    private String description;
    private String contact;


    public Restaurant(String name, Address address, String description, String contact) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }
}
