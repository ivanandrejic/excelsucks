package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

	private String day;
	private String name;

	private List<OrderItemDTO> orderItemDTOS;

	public OrderDTO(String day, String name, List<OrderItemDTO> orderItemDTOS) {
		this.day = day;
		this.name = name;
		this.orderItemDTOS = orderItemDTOS;
	}

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


	public List<OrderItemDTO> getOrderItemDTOS() {
		return orderItemDTOS;
	}

	public void setOrderItemDTOS(List<OrderItemDTO> orderItemDTOS) {
		this.orderItemDTOS = orderItemDTOS;
	}
}
