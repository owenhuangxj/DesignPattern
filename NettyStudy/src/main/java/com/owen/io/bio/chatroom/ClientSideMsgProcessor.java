package com.owen.io.bio.chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * 处理服务器端发送的消息的客户端处理器
 *
 * @author OwenHuang
 * @since 2022/11/20 20:53
 */
public class ClientSideMsgProcessor implements Runnable {
    private Socket clientSocket;

    public ClientSideMsgProcessor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        BufferedReader reader = SocketIoUtils.getReader(clientSocket);
        while (true) {
            try {
                System.out.println(reader.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
