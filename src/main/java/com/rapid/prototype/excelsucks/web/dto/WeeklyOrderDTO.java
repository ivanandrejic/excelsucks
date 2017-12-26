package com.rapid.prototype.excelsucks.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2017-12-26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeeklyOrderDTO {

    private String name;
    private BigDecimal sum;

    public WeeklyOrderDTO() {
    }

    public WeeklyOrderDTO(String name, BigDecimal sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
