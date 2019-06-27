package com.goods.gms.dao;

import com.goods.gms.pojo.DayEarning;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface DayEarningMapper {


    @Insert("insert into dayEarning(dayEarning,remarks,createTimestamp) " +
            "values(#{dayEarning},#{remarks},#{createTimestamp})")
    boolean insert(@Param("dayEarning") BigDecimal dayEarning, @Param("remarks") String remarks,
                   @Param("createTimestamp") Timestamp createTimestamp);

    @Select("select * from dayEarning order by id desc")
    List<DayEarning> selectDayEarning();




}
