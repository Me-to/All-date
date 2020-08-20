package com.example.demo;


import com.example.demo.entity.Aentity;
import com.example.demo.entity.Bentity;
import com.example.demo.service.Aservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    Aservice service;

    @Test
    public void test1(){

        List<Aentity> all = service.findAll();
       for (Aentity entity:all){
           System.out.println(entity);
       }
    }

    @Test
    public void test2(){
        List<Aentity> ab = service.AandB(1);
        for (Aentity entity:ab){
            System.out.println("22222"+entity);
        }
        }

    @Test
    public void test3(){
        List<Map<String, Object>> all1 = service.findAll1();
        for (Map a:all1){
            System.out.println(a);
        }
    }
    @Test
    public void test4(){
        List<Bentity> b=service.BandA(1);
        for (Bentity b2:b){
            System.out.println(b2);
        }
    }

    }

