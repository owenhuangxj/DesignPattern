package com.owen.io.netty.chatroom;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.DefaultEventExecutor;

import static com.owen.io.ChatroomConstants.CONTENT;

/**
 * @author OwenHuang
 * @since 2022/11/19 6:44
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private static final String ONLINE = "[%s]上线了.";
    private static final String OFFLINE = "[%s]下线了.";

    private static final String HELLO_CLIENT = "Hello,your id is:[%s].";

    /**
     * 保存客户端的Channel
     */
    private static final ChannelGroup channels = new DefaultChannelGroup(new DefaultEventExecutor());

    /**
     * 客户端连接成功的方法
     *
     * @param ctx Channel处理器上下文
     * @throws Exception 异常
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel client = ctx.channel();
        System.out.println(String.format(ONLINE, client.id()));
        ctx.writeAndFlush(String.format(HELLO_CLIENT, client.id()));
        multicast(String.format(ONLINE, client.id()));
        channels.add(client);
        System.out.println("ServerHandler:" + this);
        System.out.println("channel's size:" + channels.size());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel client = ctx.channel();
        multicast(String.format(OFFLINE, client.id()));
        channels.remove(client);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel client = ctx.channel();
        String content = String.format(CONTENT, client.id(), msg);
        System.out.println("ServerHandler:" + this);
        System.out.println(content);
        for (Channel channel : channels) {
            if (channel != client) {
                channel.writeAndFlush(content);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("哦豁，连接关闭了......");
        channels.remove(ctx.channel());
        ctx.close();
    }

    private void multicast(String msg) {
        for (Channel channel : channels) {
            channel.writeAndFlush(msg);
        }
    }
}