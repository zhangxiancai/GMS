package com.goods.gms.pojo;

import java.math.BigDecimal;

/**
 * 仓库
 */
public class Warehouse {

    private int id;
    private int goodsId;//货物id
    private BigDecimal stock;//库存总量
    private BigDecimal latestCostPrice;//最新入价
    private BigDecimal latestSellingPrice;//最新出价
    private String remarks;//备注

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getLatestCostPrice() {
        return latestCostPrice;
    }

    public void setLatestCostPrice(BigDecimal latestCostPrice) {
        this.latestCostPrice = latestCostPrice;
    }

    public BigDecimal getLatestSellingPrice() {
        return latestSellingPrice;
    }

    public void setLatestSellingPrice(BigDecimal latestSellingPrice) {
        this.latestSellingPrice = latestSellingPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
