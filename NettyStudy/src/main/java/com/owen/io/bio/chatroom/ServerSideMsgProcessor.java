package com.owen.io.bio.chatroom;/**
 * @Author：Owen
 * @Package：com.owen.io.bio.chatroom
 * @Project：NettyStudy
 * @name：ClientHandler
 * @Date：2022/11/20 15:28
 * @Filename：ClientHandler
 */

import com.owen.io.MsgFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;

/**
 * Socket服务器端处理客户端消息的处理器
 *
 * @author OwenHuang
 * @since 2022/11/20 15:28
 */
public class ServerSideMsgProcessor implements Runnable {
    private UUID uuid;
    private Socket socket;

    public ServerSideMsgProcessor(Socket socket, UUID uuid) {
        System.out.println("New client is connected......");
        this.uuid = uuid;
        this.socket = socket;
    }

    @Override
    public void run() {
        // 一直等待客户端发送的消息
        BufferedReader reader = SocketIoUtils.getReader(socket);
        while (true) {
            try {
                String msg = reader.readLine();
                String formatMsg = MsgFormatter.format(uuid, msg);
                System.out.println(formatMsg);
                Server.getInstance().multicast(socket, formatMsg);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
