package com.goods.gms.dao;

import com.goods.gms.pojo.Type;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {
    @Insert("INSERT INTO type(typeName) VALUES(#{typeName})")
    Boolean insert(@Param("typeName") String typeName );

    @Select("SELECT * FROM type WHERE id=#{id}")
    Type selectById(int id);

    @Select("SELECT * FROM type ")
    List<Type> selectAllTypes();
}
