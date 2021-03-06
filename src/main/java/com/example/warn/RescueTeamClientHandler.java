package com.example.warn;

import com.example.warn.config.Config;
import com.example.warn.model.Thing;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.text.SimpleDateFormat;

public class RescueTeamClientHandler extends SimpleChannelInboundHandler<MessagePOJO.Msg> {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        int i = 0;
        Config.map.put(i, ctx.channel().id());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Config.map.remove(0);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessagePOJO.Msg msg) throws Exception {

        Thing thing = new Thing();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(new java.util.Date());
        System.out.println(msg.getAddress() + "发来车祸报警,车祸类型为" + msg.getType() + "，时间为：" + str);
       /* thing.setAddress(msg.getAddress());
        thing.setType(msg.getType());
        thing.setTime(str);
        int i = rescueTeamClientHandler.thingService.insertSelective(thing);
        if (i == 1) {
            System.out.println("已保存到数据库当中");
        }*/
    }
}
