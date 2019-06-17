package com.goods.gms.dao;

import com.goods.gms.pojo.Warehouse;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface WarehouseMapper {

    @Insert("insert into wareHouse(goodsId,stock,latestCostPrice,latestSellingPrice,remarks)" +
            " values(#{goodsId},#{stock},#{latestCostPrice},#{latestSellingPrice},#{remarks})")
    boolean insert(@Param("goodsId") int goodsId, @Param("stock") BigDecimal stock,
                   @Param("latestCostPrice") BigDecimal latestCostPrice, @Param("latestSellingPrice") BigDecimal latestSellingPrice,   @Param("remarks") String remarks);



    @Update("update warehouse set latestCostPrice=#{goodsUnitPrice},stock=stock+#{goodsQuantity} where goodsId=#{goodsId}")
    boolean updateByPurchaseOrder(@Param("goodsId") int goodsId, @Param("goodsUnitPrice") BigDecimal goodsUnitPrice,
                                  @Param("goodsQuantity") BigDecimal goodsQuantity);

    @Update("update warehouse set latestSellingPrice=#{goodsUnitPrice},stock=stock-#{goodsQuantity} where goodsId=#{goodsId}")
    boolean updateByShipmentOrder(@Param("goodsId") int goodsId, @Param("goodsUnitPrice") BigDecimal goodsUnitPrice,
                                  @Param("goodsQuantity") BigDecimal goodsQuantity);
    @Select("select t.typeName, g.goodsName, g.goodsUnit,w.stock, w.latestCostPrice,w.latestSellingPrice " +
            "FROM warehouse as w,goods as g,type as t " +
            "where w.goodsId=g.id and g.typeId=t.id")
    List<Warehouse> selectWarehouse();

}
