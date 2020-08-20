package com.example.demo.dao;

import com.example.demo.domain.bootstrap1;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Bdao {

    @Select("select * from bootstrap1")
    List<bootstrap1> findAll();

    @Insert("insert into bootstrap1  (name,age,money,telphone) values(#{name},#{age},#{money},#{telephone})")
    void add(bootstrap1 message);
}
