package com.owen.io.netty.chatroom;

/**
 * @author OwenHuang
 * @since 2022/11/19 11:58
 */
public class ClientApp {
    public static void main(String[] args) throws Exception {
        ClientFrame client = ClientFrame.getInstance();
        client.connectToServer(8888);
    }
}
