package com.rapid.prototype.excelsucks.web.dto;

import java.util.List;

public class OrderBuilder {
    private String day = "0";
    private String name = "name";
    private List<OrderItemDTO> orderList;

    public OrderDTO createOrderDTO() {
        return new OrderDTO(day, name, orderList);
    }

    public OrderBuilder setDay(String day) {
        this.day = day;
        return this;
    }

    public OrderBuilder setOrderList(List<OrderItemDTO> orderList) {
        this.orderList = orderList;
        return this;
    }

    public OrderBuilder setName(String name) {
        this.name = name;
        return this;
    }
}