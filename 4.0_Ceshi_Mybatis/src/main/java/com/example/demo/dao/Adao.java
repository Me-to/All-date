package com.example.demo.dao;

import com.example.demo.entity.Aentity;
import com.example.demo.entity.Bentity;

import java.util.List;
import java.util.Map;

public interface Adao {

     List<Aentity> findAll();

     List<Map<String, Object>> findAll1();

     List<Aentity> AandB(int id);

     List<Bentity> BandA(int id);
}
