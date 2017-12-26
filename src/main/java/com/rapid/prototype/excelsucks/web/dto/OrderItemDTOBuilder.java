package com.rapid.prototype.excelsucks.web.dto;

import java.util.List;

public class OrderItemDTOBuilder {
    private Long id;
    private String name;
    private List<FoodItemDTO> foodItems;

    public OrderItemDTO createOrderItemDTO() {
        return new OrderItemDTO(id, name, foodItems);
    }

    public OrderItemDTOBuilder setFoodItems(List<FoodItemDTO> foodItems) {
        this.foodItems = foodItems;
        return this;
    }

    public OrderItemDTOBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderItemDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }
}