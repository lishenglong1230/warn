package lsl.warn;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
         new Thread(()->{

             Scanner sc=new Scanner(System.in);
             System.out.println("请输地址\n");
             String address=sc.nextLine();
             System.out.println("请输入类型\n");
             String type=sc.nextLine();
             MessagePOJO.Msg message = MessagePOJO.Msg.newBuilder().setAddress(address).setType(type).build();

             ctx.writeAndFlush(message);

         }).start();
    }
}
