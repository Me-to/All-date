package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Bentity {
    int bid;
    String bname;
    int bmoney;
    List<Aentity> aentity;
}
