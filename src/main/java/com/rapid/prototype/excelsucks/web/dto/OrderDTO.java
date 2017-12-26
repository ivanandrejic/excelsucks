package com.rapid.prototype.excelsucks.web.dto;

import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
public class OrderDTO {

	private String day;
	private String name;

	private List<FoodItemDTO> foodList;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodItemDTO> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodItemDTO> foodList) {
		this.foodList = foodList;
	}
}
