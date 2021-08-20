package com.example.warn.config;

import io.netty.channel.ChannelId;

import java.util.concurrent.ConcurrentHashMap;

public class Config {
    public static ConcurrentHashMap<Integer, ChannelId> map = new ConcurrentHashMap<Integer, ChannelId>();
    public  int i=0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
