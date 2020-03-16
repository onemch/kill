package com.debug.kill.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Aoy
 * @create 2020-03-14 17:02
 */
@Controller
@RequestMapping("base")
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @GetMapping("/welcome")
    public String welcome(String name , Map map){
        if (StringUtils.isEmpty(name)){
            name = "这是WELCOME页面";
        }
        map.put("name",name);
        return "welcome";
    }

    @GetMapping("/data")
    @ResponseBody
    public String data(String name ){
        if (StringUtils.isEmpty(name)){
            name = "这是WELCOME页面";
        }
        return name;
    }


}
