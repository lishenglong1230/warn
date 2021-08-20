package com.example.warn.service.impl;

import com.example.warn.mapper.ThingMapper;
import com.example.warn.model.Thing;
import com.example.warn.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: Lishenglong
 * @Date: 2021/8/20 11:18
 */
@Component
public class ThingServiceImpl implements ThingService {

    @Autowired
    private ThingMapper thingMapper;


    @Override
    public Thing queryThingById(Integer id) {
        return thingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Thing thing) {
        return thingMapper.insertSelective(thing);
    }


}
