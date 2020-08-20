package com.example.demo.service;

import com.example.demo.dao.Adao;
import com.example.demo.entity.Aentity;
import com.example.demo.entity.Bentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Aservice {
    @Autowired
    Adao adao;

    public List<Aentity> findAll(){
        return adao.findAll();
    }

    public List<Aentity> AandB(int id){
        return adao.AandB(id);
    }

    public List<Map<String, Object>> findAll1(){
        return adao.findAll1();
    }

    public List<Bentity> BandA(int id){
        return adao.BandA(id);
    }
}
