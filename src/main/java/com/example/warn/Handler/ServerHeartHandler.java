package com.example.warn.Handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHeartHandler extends ChannelInboundHandlerAdapter {

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
}
