package com.debug.kill.server.service.Impl;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.mapper.ItemKillMapper;
import com.debug.kill.server.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aoy
 * @create 2020-03-15 18:11
 */
@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Override
    public List<ItemKill> getKillItem() throws Exception {
        return itemKillMapper.selectAll();
    }

    @Override
    public ItemKill getKillDetail(Integer id) throws Exception {
        ItemKill itemKill = itemKillMapper.selectById(id);
        if (itemKill == null){
            throw new Exception("记录不存在");
        }
        return itemKill;
    }
}
