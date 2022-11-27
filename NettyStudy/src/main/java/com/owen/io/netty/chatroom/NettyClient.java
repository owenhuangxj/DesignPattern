package com.owen.io.netty.chatroom;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.StandardCharsets;

/**
 * @author OwenHuang
 * @since 2022/11/19 9:16
 */
public class NettyClient {
    private Channel channel;

    public void connect(int port) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("decoder", new StringDecoder(StandardCharsets.UTF_8))
                                    .addLast("encoder", new StringEncoder(StandardCharsets.UTF_8))
                                    .addLast("clientHandler", new ClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect("localhost", port);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("Connect to server success.");
                        channel = channelFuture.channel();
                    } else {
                        System.out.println("Connect failed......");
                    }
                }
            });
            future.sync();
            // Wait until the connection is closed.
            future.channel().closeFuture().sync();
            while (true) {
                Thread.sleep(1000);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public void sendMsg(String msg) {
        channel.writeAndFlush(msg);
    }
}
