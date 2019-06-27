package com.goods.gms.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 日收入
 */
public class DayEarning {

    private BigDecimal dayEarning;//日收入
    private String remarks;//备注
    private Timestamp createTimestamp;//创建时间

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getDayEarning() {
        return dayEarning;
    }

    public void setDayEarning(BigDecimal dayEarning) {
        this.dayEarning = dayEarning;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
