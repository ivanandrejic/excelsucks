package com.rapid.prototype.excelsucks.web.dto;

import java.math.BigDecimal;
import java.util.List;

public class WeeklyOrdersBuilder {
    private BigDecimal totalSum;
    private List<WeeklyOrderDTO> orders;

    public WeeklyOrdersDTO createWeeklyOrdersDTO() {
        return new WeeklyOrdersDTO(totalSum, orders);
    }

    public WeeklyOrdersBuilder setOrders(List<WeeklyOrderDTO> orders) {
        this.orders = orders;
        return this;
    }

    public WeeklyOrdersBuilder setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
        return this;
    }
}