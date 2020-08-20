package com.example.demo.controller;


import com.example.demo.domain.bootstrap1;
import com.example.demo.service.Bservice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("a")
public class Bcontr {
@Autowired
    Bservice bservice;


    @GetMapping("findAll")
    public Map<String, Object> findAll(@RequestParam Map querys){
        return bservice.findAll(querys);
    }

    @PostMapping("add")
    public Map add(@RequestBody bootstrap1 message){
     return   bservice.add(message);

    }



}
