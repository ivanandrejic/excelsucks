package com.rapid.prototype.excelsucks.web.dto;

import java.math.BigDecimal;

public class FoodItemBuilder {
    private Long id = 1l;
    private String title = "naslov";
    private String description = "opis";
    private String photoURI = "photoURI";
    private BigDecimal price = new BigDecimal(10);

    public FoodItemDTO createFoodItemDTO() {
        return new FoodItemDTO(id, title, description, photoURI, price);
    }

    public FoodItemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public FoodItemBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodItemBuilder setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
        return this;
    }

    public FoodItemBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public FoodItemBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
}