package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryFoodList {

	private List<FoodItemDTO> foodItems;

	public SummaryFoodList() {
	}

	public List<FoodItemDTO> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItemDTO> foodItems) {
		this.foodItems = foodItems;
	}
}
