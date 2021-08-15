package lsl.warn;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lsl.warn.config.Config;

import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;

public class RescueTeamClientHandler extends SimpleChannelInboundHandler<MessagePOJO.Msg> {

 /*   @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        int i=0;
        Config.map.put(i,ctx.channel().id());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Config.map.remove(0);
    }*/

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessagePOJO.Msg msg) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(msg.getAddress() + "发来车祸报警,车祸类型为" + msg.getType() + "，时间为：" + sdf.format(new java.util.Date()));
    }
}
