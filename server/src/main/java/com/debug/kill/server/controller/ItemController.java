package com.debug.kill.server.controller;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.server.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author Aoy
 * @create 2020-03-15 17:58
 */
@Controller
public class ItemController {

    private static final String prefix = "item";

    @Autowired
    private IItemService itemService;

    @RequestMapping(value ={"/","index",prefix+"/list",prefix+"/index.html"} ,method = RequestMethod.GET)
    public String list(Map map){
        try {
            List<ItemKill> list = itemService.getKillItem();
            map.put("list",list);
        }catch (Exception e){
            System.err.println("获取待秒杀商品列表异常");
            return "redirect:/base/error";
        }
        return "list";
    }

    @GetMapping(prefix+"/detail/{id}")
    public String detail(@PathVariable Integer id,Map map){
        if (id==null || id<=0){
            return "redirect:/base/error";
        }
        try {
            ItemKill detail = itemService.getKillDetail(id);
            map.put("detail",detail);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "info";
    }
}
