package com.owen.io.bio.chatroom;/**
 * @Author：Owen
 * @Package：com.owen.io.bio.chatroom
 * @Project：NettyStudy
 * @name：ClientApplication
 * @Date：2022/11/20 14:31
 * @Filename：ClientApplication
 */

/**
 * @author OwenHuang
 * @since 2022/11/20 14:31
 */
public class ClientApplication {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        client.connectServer(6666);
    }
}
