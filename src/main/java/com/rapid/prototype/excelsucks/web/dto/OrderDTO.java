package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rapid.prototype.excelsucks.domain.Order;

import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

	private String day;
	private String name;
	private List<OrderItemDTO> foodList;

	public OrderDTO() {
	}

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

	public List<OrderItemDTO> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<OrderItemDTO> foodList) {
		this.foodList = foodList;
	}
}
