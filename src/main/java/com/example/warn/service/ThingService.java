package com.example.warn.service;

import com.example.warn.model.Thing;
import org.springframework.stereotype.Component;

/**
 * @Author: Lishenglong
 * @Date: 2021/8/20 11:17
 */
public interface ThingService {
    /**
     * 根据事件id查询详情
     * @param id
     * @return
     */
    Thing queryThingById(Integer id);

    int insertSelective(Thing thing);


}
