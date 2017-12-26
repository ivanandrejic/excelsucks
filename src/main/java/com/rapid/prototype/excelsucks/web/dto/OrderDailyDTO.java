package com.rapid.prototype.excelsucks.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrderDailyDTO {

    @JsonProperty("food_name")
    private String foodName;
    private List<String> names = new ArrayList<>();
    private Integer count = 0;

}
