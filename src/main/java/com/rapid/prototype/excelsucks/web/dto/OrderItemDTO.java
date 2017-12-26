package com.rapid.prototype.excelsucks.web.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderItemDTO {

    private Long id;

    private String name;

    private List<FoodItemDTO> foodItems;
}
