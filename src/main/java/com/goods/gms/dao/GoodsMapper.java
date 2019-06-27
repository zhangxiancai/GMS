package com.goods.gms.dao;

import com.goods.gms.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface GoodsMapper {


    @Insert("insert into goods(goodsName,typeId,imageAddress,remarks,createTimestamp,goodsUnit) " +
            "values(#{goodsName},#{typeId},#{imageAddress},#{remarks},#{createTimestamp},#{goodsUnit})")
    public boolean insert(@Param("goodsName") String goodsName,
                          @Param("typeId")int typeId,
                          @Param("imageAddress")String imageAddress,
                          @Param("remarks")String remarks,
                          @Param("createTimestamp")Timestamp createTimestamp,
                          @Param("goodsUnit")String goodsUnit);

    @Select("select * from goods limit #{pageNumber} #{pageSize}")
    public List<Goods> selectGoods(@Param("pageNumber")int pageNumber,@Param("pageSize")int pageSize);

    @Select("select * from goods order by id desc")
    public List<Goods> selectAllGoods();

    @Select("select * from goods where goodsName=#{goodsName} limit #{pageNumber} #{pageSize}")
    public List<Goods> selectGoodsByName( @Param("goodsName")String goodsName,
                                          @Param("pageNumber")int pageNumber,@Param("pageSize")int pageSize);

    @Select("select * from goods where typeId=#{typeId} limit #{pageNumber} #{pageSize}")
    public List<Goods> selectGoodsByType( @Param("typeId")int typeId,
                                          @Param("pageNumber")int pageNumber,@Param("pageSize")int pageSize);

    @Select("select name from goods where id=#{id}")
    public String selectNamebyId(int id);

    @Select("SELECT LAST_INSERT_ID()")
    int returnLastId();

}
