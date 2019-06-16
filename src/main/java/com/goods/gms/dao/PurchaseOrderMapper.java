package com.goods.gms.dao;

import com.goods.gms.pojo.PurchaseOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PurchaseOrderMapper {

    @Insert("insert into purchaseOrder(goodsId,userId,goodsUnit,goodsQuantity,goodsUnitPrice,goodsTotalPrice,createTimestamp,remarks)" +
            "values(#{goodsId},#{userId},#{goodsUnit},#{goodsQuantity},#{goodsUnitPrice},#{goodsTotalPrice},#{createTimestamp},#{remarks})")
    boolean insert(@Param("goodsId")int goodsId, @Param("userId")int userId,
                   @Param("goodsUnit")String goodsUnit, @Param("goodsQuantity") BigDecimal goodsQuantity,
                   @Param("goodsUnitPrice")BigDecimal goodsUnitPrice, @Param("goodsTotalPrice")BigDecimal goodsTotalPrice,
                   @Param("createTimestamp")Timestamp createTimestamp, @Param("remarks")String remarks);

    @Select("select g.goodsName,p.id,p.userId,p.goodsUnit,p.goodsQuantity,p.goodsUnitPrice,p.goodsTotalPrice," +
            "p.remarks,p.createTimeStamp from purchaseOrder as p,goods as g where p.goodsId=g.id order by id desc")
    List<PurchaseOrder> selectAllpurchaseOrder();
}
