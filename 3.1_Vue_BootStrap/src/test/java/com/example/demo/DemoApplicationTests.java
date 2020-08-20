package com.example.demo;

import com.example.demo.controller.Bcontr;
import com.example.demo.dao.Bdao;
import com.example.demo.domain.bootstrap1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

    @Autowired
    Bdao dao;

    @Autowired
    Bcontr bcontr;

    @Test
  public  void contextLoads() {

        List<bootstrap1> all = dao.findAll();
        for (bootstrap1 b:all){
            System.out.println(b);
        }
    }

//    @Test
//    public void a(){
//        List all = bcontr.findAll();
//        System.out.println(all);
//    }

    @Test
    public void add(){
         bootstrap1 b=new bootstrap1();
         b.setAge("15");
         b.setMoney("122");
         b.setName("zhagn");
         b.setTelephone("45645");
         bcontr.add(b);
    }

}
