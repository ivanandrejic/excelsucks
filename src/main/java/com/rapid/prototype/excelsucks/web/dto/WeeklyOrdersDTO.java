package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeeklyOrdersDTO {

    @JsonProperty("total_sum")
    private BigDecimal totalSum;

    private List<WeeklyOrderDTO> orders;

    public WeeklyOrdersDTO() {
    }

    public WeeklyOrdersDTO(BigDecimal totalSum, List<WeeklyOrderDTO> orders) {
        this.totalSum = totalSum;
        this.orders = orders;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public List<WeeklyOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<WeeklyOrderDTO> orders) {
        this.orders = orders;
    }
}
