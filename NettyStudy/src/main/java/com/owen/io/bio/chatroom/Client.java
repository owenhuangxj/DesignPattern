package com.owen.io.bio.chatroom;

import com.owen.io.ProjectThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author OwenHuang
 * @since 2022/11/12 20:33
 */
public class Client {
    private static Client instance;

    private Client() {
    }

    public static Client getInstance() {
        if (instance == null) {
            synchronized (Client.class) {
                if (instance == null) {
                    instance = new Client();
                }
            }
        }
        return instance;
    }

    private Socket clientSocket;

    public void connectServer(int port) {
        try {
            clientSocket = new Socket("127.0.0.1", port);
            // 启动多个客戶端时使用线程池没有意义，因为启动一个客户端就是启动一个虚拟机
            // ProjectThreadPool.getInstance().execute(new ClientSideMsgProcessor(clientSocket));
            new Thread(new ClientSideMsgProcessor(clientSocket)).start();
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\r|\n|\r\n");
            PrintWriter writer = SocketIoUtils.getWriter(clientSocket);
            while (scanner.hasNext()) {
                writer.println(scanner.next());
                writer.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}