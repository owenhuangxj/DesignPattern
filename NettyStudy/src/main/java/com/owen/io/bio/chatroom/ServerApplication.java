package com.owen.io.bio.chatroom;
/**
 * @Author：Owen
 * @Package：com.owen.io.bio.chatroom
 * @Project：NettyStudy
 * @name：ServerApplication
 * @Date：2022/11/20 14:11
 * @Filename：ServerApplication
 */

import java.io.IOException;

/**
 * @author OwenHuang
 * @since 2022/11/20 14:11
 */
public class ServerApplication {
    public static void main(String[] args) throws IOException {
        Server.getInstance().start();
    }
}
