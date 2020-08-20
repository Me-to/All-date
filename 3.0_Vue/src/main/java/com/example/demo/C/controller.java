package com.example.demo.C;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("a")
public class controller {

    @GetMapping("b")
    @ResponseBody
    @CrossOrigin
    public Map<String, String> weathers( String name) {
        Map<String, String> map = new HashMap();
        String weather = getWeather(name);
        map.put("message", weather);
        return map;
    }

    public String getWeather(String name) {
        Map<String, String> map = new HashMap<>();
        map.put("上海", "天气晴,温度良好");
        map.put("北京", "天气阴有大雨");
        map.put("济南", "出现冰雹现象");
        return map.get(name);

    }


}
