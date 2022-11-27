package com.owen.io.netty.chatroom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.StringUtil;

/**
 * @author OwenHuang
 * @since 2022/11/19 9:21
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    ClientFrame clientFrame = ClientFrame.getInstance();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 将消息更新到聊天窗口
        String windowsText = clientFrame.getWindowsText();

        clientFrame.updateWindows((StringUtil.isNullOrEmpty(windowsText) ? "" :
                windowsText + System.lineSeparator()) + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
