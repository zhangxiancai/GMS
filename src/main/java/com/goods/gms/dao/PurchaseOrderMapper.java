package com.goods.gms.dao;

import com.goods.gms.pojo.DaySpending;
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

    @Insert("insert into purchaseOrder(goodsId,userId,goodsQuantity,goodsUnitPrice,goodsTotalPrice,createTimestamp,remarks)" +
            "values(#{goodsId},#{userId},#{goodsQuantity},#{goodsUnitPrice},#{goodsTotalPrice},#{createTimestamp},#{remarks})")
    boolean insert(@Param("goodsId")int goodsId, @Param("userId")int userId,
                   @Param("goodsQuantity") BigDecimal goodsQuantity,
                   @Param("goodsUnitPrice")BigDecimal goodsUnitPrice, @Param("goodsTotalPrice")BigDecimal goodsTotalPrice,
                   @Param("createTimestamp")Timestamp createTimestamp, @Param("remarks")String remarks);

    @Select("select g.goodsName,g.goodsUnit,p.id,p.userId,p.goodsQuantity,p.goodsUnitPrice,p.goodsTotalPrice," +
            "p.remarks,p.createTimeStamp from purchaseOrder as p,goods as g where p.goodsId=g.id order by id desc")
    List<PurchaseOrder> selectAllPurchaseOrder();


    @Select("select DATE_FORMAT(createTimestamp,'%Y-%m-%d')date,sum(goodsTotalPrice)daySpending" +
            " from purchaseOrder group by date order by date desc limit 0,180")
    List<DaySpending> selectDaySpending();

    /**
     * 获得根据日期分类的标识
     *
     */
//    @Select("SELECT" +
//            "@temp:= case when @date=DATE_FORMAT(p.createTimestamp,'%Y-%m-%d') then @temp else @temp+1 end as temp," +
//            "@date:=DATE_FORMAT(p.createTimestamp,'%Y-%m-%d') as day" +
//            "from purchaseOrder as p,(select @temp:=0,@date='') as b " +
//            "order by id desc")
//    List<PurchaseOrder> selectPurchaseOrderTemp();

    @Select("call cunchu1(1)")
    List<PurchaseOrder> selectPurchaseOrderTemp();
}
