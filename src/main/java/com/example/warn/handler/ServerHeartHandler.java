package com.example.warn.handler;

import com.example.warn.entity.Message;
import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHeartHandler extends SimpleChannelInboundHandler<Message> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event=(IdleStateEvent) evt;
            String eventType=null;
            if(event.state()==IdleState.READER_IDLE){
                eventType="读空闲";
            }
            System.out.println(ctx.channel().remoteAddress()+"--超时--"+eventType);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        //Message message = new Gson().fromJson(String.valueOf(msg),Message.class);
    }
}
