package com.example.warn;

import com.example.warn.mapper.ThingMapper2;
import com.example.warn.model.Thing;
import com.example.warn.service.impl.ThingServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WarnApplication.class)

class WarnApplicationTests {

    @Autowired
    ThingServiceImpl thingService;

    @Test
    void contextLoads() {
        thingService.queryThingById(1);
    }


}
