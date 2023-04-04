package com.example.webdemo1.mapper;


import com.example.webdemo1.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> findall();

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users getUserById(@Param("id") Long id);

    @Select("SELECT * FROM users WHERE name = #{name}")
    List<Users> getUserList(@Param("name") String name);

    @Insert("INSERT INTO users(name, age) VALUES (#{name},#{age})")
    void addUsers(Users users);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void deleteUserById(@Param("id") Long id);

    @Update("UPDATE users SET name=#{name}, age=#{age} WHERE id=#{id}")
    void updateUser(Users users);
}
