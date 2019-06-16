package com.goods.gms.pojo;

import java.sql.Timestamp;

/**
 * 货物
 */
public class Goods {

     private int id;
     private String goodsName;//商品名称
     private int typeId;//类型id
     private String imageAdress;//货物图片地址
     private boolean isReturned;//可否退货
     private String remarks;//备注
    private Timestamp createTimestamp;//创建时间


    private  String typeName;
    private  String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getImageAdress() {
        return imageAdress;
    }

    public void setImageAdress(String imageAdress) {
        this.imageAdress = imageAdress;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Timestamp getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Timestamp createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
