package com.goods.gms.dao;
import com.goods.gms.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username,password) VALUES(#{username},#{password})")
    Boolean insert(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User selectById(int id);

    @Select("SELECT * FROM user ")
    List<User> selectAllUsers();

}
