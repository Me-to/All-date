package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@ResponseBody
public class test {


    @RequestMapping("p")
    public Object a(String a,String b) {
        UUID uuid = UUID.randomUUID();
        Object id = uuid.toString();
        System.out.println("id" + id + "      "+"a:"+a+" "+"b:"+b );
        return id;
    }
}
