package lsl.warn;

import com.google.gson.Gson;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lsl.warn.config.Config;

import java.text.SimpleDateFormat;

public class WarnServerHandler extends SimpleChannelInboundHandler<MessagePOJO.Msg> {

    //定义一个channle 组，管理所有的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //handlerAdded 表示连接建立，一旦连接，第一个被执行
    //将当前channel 加入到  channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Config config=new Config();
        int num=config.getI();
        num=num+2;
        config.setI(num);
        Config.map.put(num,ctx.channel().id());
        System.out.println(Config.map.get(num));
        System.out.println(config.getI());
        Channel channel = ctx.channel();
        System.out.println(ctx.channel().remoteAddress()+"连接到服务器");
        channelGroup.add(channel);
    }

    //断开连接, 将xx客户离开信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Config config=new Config();
        int num=config.getI();
        num--;
        channelGroup.remove(ctx.channel());
        Config.map.remove(num);
        Channel channel = ctx.channel();
        System.out.println("[客户端]" + channel.remoteAddress() + " 已处理好车祸现场\n");

    }

    //读取警报数据
    @Override
    public void channelRead0(ChannelHandlerContext ctx, MessagePOJO.Msg msg) throws Exception {
        System.out.println("开始读");

        //获取到当前channel
        Channel channel = ctx.channel();
        //遍历channelGroup, 根据不同的情况，回送不同的消息
    /*    channelGroup.forEach(ch -> {
            if (channel != ch) { //不是当前的channel,转发消息
                System.out.println(msg.getAddress()+"发来报警");
                ch.writeAndFlush(msg);
            } else {//回显自己发送的消息给自己，提示自己已报警，加时间
                System.out.println("没接到消息");
                ch.writeAndFlush(msg);
            }
        });*/
        ChannelId channelId= Config.map.get(1);
        System.out.println(channelId);
        if(channelId==null){
            sendMessageForAll("对方已下线");
        }else {
           channelGroup.find(channelId).writeAndFlush(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }
    private void sendMessageForAll(String message) {
        for (Channel channel : channelGroup) {
            channel.writeAndFlush(message);
        }
    }
}
