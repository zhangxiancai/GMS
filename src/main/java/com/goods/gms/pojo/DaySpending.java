package com.goods.gms.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 日支出
 */
public class DaySpending {

    private BigDecimal daySpending;//日支出
    private Timestamp date;//日期

    private String stringDate;


    public BigDecimal getDaySpending() {
        return daySpending;
    }

    public void setDaySpending(BigDecimal daySpending) {
        this.daySpending = daySpending;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }
}
