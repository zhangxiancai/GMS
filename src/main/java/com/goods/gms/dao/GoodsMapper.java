package com.goods.gms.dao;

import com.goods.gms.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {


    @Insert("insert into Goods(goodsName,typeId,imageAddress,isReturned,remarks,creatTimestamp) " +
            "values(#{goodsName},#{typeId},#{imageAddress},#{isReturned},#{remarks},#{creatTimestamp})")
    public boolean insert(String goodsName,int typeId,String imageAddress,boolean isReturned,String remarks,long creatTimestamp);

    @Select("select * from Goods")
    public List<Goods> selectAllGoods();

    @Select("select * from Goods where goodsName=#{goodsName}")
    public List<Goods> selectGoodsByName(String goodsName);

}
