package com.example.warn;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Lishenglong
 * @Date: 2021/8/22 1:27
 */

@Component
public class WarnServerInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private WarnServerHandler warnServerHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //获取到pipeline
        ChannelPipeline pipeline = ch.pipeline();
        //向pipeline加入编码器
        pipeline.addLast("encoder",new ProtobufEncoder());
        //向pipeline加入解码器
        pipeline.addLast("decoder", new ProtobufDecoder(MessagePOJO.Msg.getDefaultInstance()));

        //加入自己的业务处理handler
        pipeline.addLast(warnServerHandler);
    }
}
