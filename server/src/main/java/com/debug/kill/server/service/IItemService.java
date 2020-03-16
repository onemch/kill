package com.debug.kill.server.service;

import com.debug.kill.model.entity.ItemKill;

import java.util.List;

/**
 * @author Aoy
 * @create 2020-03-15 18:09
 */
public interface IItemService {
    List<ItemKill> getKillItem() throws Exception;

    ItemKill getKillDetail(Integer id) throws Exception;
}
