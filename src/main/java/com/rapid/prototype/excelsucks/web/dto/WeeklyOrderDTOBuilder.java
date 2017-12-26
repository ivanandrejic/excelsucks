package com.rapid.prototype.excelsucks.web.dto;

import java.math.BigDecimal;

public class WeeklyOrderDTOBuilder {
    private String name;
    private BigDecimal sum;

    public WeeklyOrderDTO createWeeklyOrderDTO() {
        return new WeeklyOrderDTO(name, sum);
    }

    public WeeklyOrderDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WeeklyOrderDTOBuilder setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }
}