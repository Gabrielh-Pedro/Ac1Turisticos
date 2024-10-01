package com.example.turistico;

import java.io.Serializable;

public class Place implements Serializable {
    String name;
    String description;
    int imageResource;
    String mapLink;
    String website;
    String phone;

    public Place(String name, String description, int imageResource, String mapLink, String website, String phone) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
        this.mapLink = mapLink;
        this.website = website;
        this.phone = phone;
    }
}
