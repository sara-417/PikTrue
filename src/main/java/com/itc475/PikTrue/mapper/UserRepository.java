package com.itc475.PikTrue.mapper;

import com.itc475.PikTrue.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserRepository {

    @Select("SELECT * FROM users WHERE user_name = #{username} AND password = #{password}")
    @Results(id = "LoginDataResult", value = {
            @Result(column = "uid", property = "uid", id = true),
            @Result(column = "user_name", property = "user_name"),
            @Result(column = "password", property = "password")
    })
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
