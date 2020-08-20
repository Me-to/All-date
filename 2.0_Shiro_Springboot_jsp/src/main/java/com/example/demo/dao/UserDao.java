package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.utils.SaltUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserDao {
    @Insert("insert into user2 values(#{id},#{username},#{password},#{salt})")
    void save(User user);

    @Select("select * from user2 where username=#{username}")
    User findByUsername(String username);
}
