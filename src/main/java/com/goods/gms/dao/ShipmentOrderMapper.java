package com.goods.gms.dao;


import com.goods.gms.pojo.ShipmentOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ShipmentOrderMapper {


    @Insert("insert into shipmentOrder(goodsId,userId,goodsQuantity,goodsUnitPrice,goodsTotalPrice,createTimestamp,remarks)" +
            "values(#{goodsId},#{userId},#{goodsQuantity},#{goodsUnitPrice},#{goodsTotalPrice},#{createTimestamp},#{remarks})")
    boolean insert(@Param("goodsId")int goodsId, @Param("userId")int userId,
                   @Param("goodsQuantity") BigDecimal goodsQuantity,
                   @Param("goodsUnitPrice")BigDecimal goodsUnitPrice, @Param("goodsTotalPrice")BigDecimal goodsTotalPrice,
                   @Param("createTimestamp")Timestamp createTimestamp, @Param("remarks")String remarks);

    @Select("select g.goodsName,g.goodsUnit,s.id,s.userId,s.goodsQuantity,s.goodsUnitPrice,s.goodsTotalPrice," +
            "s.remarks,s.createTimeStamp from shipmentOrder as s,goods as g where s.goodsId=g.id order by id desc")
    List<ShipmentOrder> selectAllShipmentOrder();
}
