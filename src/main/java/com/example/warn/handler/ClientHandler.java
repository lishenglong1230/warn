package com.example.warn.handler;

import com.example.warn.entity.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
         new Thread(()->{
             Scanner sc=new Scanner(System.in);
             System.out.println("请输入姓名\n");
             String name=sc.nextLine();
             System.out.println("请输入车牌号\n");
             String arNumber=sc.nextLine();
             System.out.println("请输入路段\n");
             String railway=sc.nextLine();
             System.out.println("请输入类型\n");
             String type=sc.nextLine();
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
             String date = sdf.format(new Date());
             Message message=new Message(name,arNumber,railway,type,date);
             ctx.write(message);

         }).start();
    }
}
