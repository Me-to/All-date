package com.example.demo.service;

import com.example.demo.dao.Bdao;
import com.example.demo.domain.bootstrap1;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class Bservice {

    @Autowired
    Bdao bdao;


    public Map<String, Object> findAll(Map querys) {
        int startPage=Integer.parseInt((String) querys.get("page"));
        int pageSize=Integer.parseInt((String) querys.get("limit"));
        if (String.valueOf(pageSize)==null){
            pageSize=10;
        }  if (String.valueOf(startPage)==null){
            pageSize=1;
        }
        Page page=PageHelper.startPage(startPage,pageSize);
        List<bootstrap1> bootstrap1s=bdao.findAll();
        long total = page.getTotal();
        HashMap<String, Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","请求 成功");
        map.put("data",bootstrap1s);
        map.put("count",total);
        return map;

    }

    public Map add(bootstrap1 message) {
        Map<String, String> map=new HashMap<>();
        try {
            if (StringUtils.isEmpty(message.getAge()) || !Pattern.matches(message.getAge(),"\\s+") ||StringUtils.isEmpty(message.getName())||StringUtils.isEmpty(message.getMoney())||StringUtils.isEmpty(message.getTelephone())){
               map.put("response","fail");
                System.out.println("fail");
                return map;
            }else {
                 bdao.add(message);
                 map.put("response","success");
                System.out.println("success");
                 return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("response","fail");    System.out.println("fail1");
            return map;
        }

    }

}
