package com.rapid.prototype.excelsucks.web.dto;

import java.math.BigDecimal;

public class FoodItemDTOBuilder {
    private Long id;
    private String title;
    private String description;
    private String photoURI;
    private BigDecimal price;

    public FoodItemDTO createFoodItemDTO() {
        return new FoodItemBuilder().setId(id).setTitle(title).setDescription(description).setPhotoURI(photoURI).setPrice(price).createFoodItemDTO();
    }

    public FoodItemDTOBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public FoodItemDTOBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public FoodItemDTOBuilder setPhotoURI(String photoURI) {
        this.photoURI = photoURI;
        return this;
    }

    public FoodItemDTOBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public FoodItemDTOBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
}