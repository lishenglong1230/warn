package com.example.warn.service.impl;

import com.example.warn.mapper.ThingMapper;
import com.example.warn.mapper.ThingMapper2;
import com.example.warn.model.Thing;
import com.example.warn.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Lishenglong
 * @Date: 2021/8/20 11:18
 */

@Service
public class ThingServiceImpl implements ThingService {


    @Autowired
    ThingMapper2 thingMapper2;

    @Override
    public Thing queryThingById(Integer id) {
        return thingMapper2.findById(id);
    }

    @Override
    public int insertSelective(Thing thing) {
        return thingMapper2.insertByThing(thing);
    }


}
