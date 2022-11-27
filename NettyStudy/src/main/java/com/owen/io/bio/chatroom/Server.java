package com.owen.io.bio.chatroom;

import com.owen.io.ProjectThreadPool;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @author OwenHuang
 * @since 2022/11/20 11:20
 */
public class Server {
    private ServerSocket serverSocket;
    private static final Map<Socket, UUID> clientSockets = new HashMap<>();

    private Server(String hostname, int port) {
        try {
            this.serverSocket = new ServerSocket();
            this.serverSocket.bind(new InetSocketAddress(hostname, port));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Server getInstance() {
        return ServerHolder.INSTANCE;
    }

    public void removeClient(Socket clientSocket) {
        clientSockets.remove(clientSocket);
    }


    public static final class ServerHolder {
        private static final Server INSTANCE = new Server("localhost", 6666);
    }

    public void start() {
        try {
            /**
             * Listens for a connection to be made to this socket and accepts it.
             * The method blocks until a connection is made.
             * while.true 循环等待客户端连接
             */
            while (true) {
                Socket client = this.serverSocket.accept();
                UUID uuid = UUID.randomUUID();
                clientSockets.put(client, uuid);
                PrintWriter writer = SocketIoUtils.getWriter(client);
                writer.println("Hello,your id is:[" + uuid + "]");
                writer.flush();
                // 连接上之后启动一个线程处理
                ProjectThreadPool.getInstance().execute(new ServerSideMsgProcessor(client, uuid));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 广播消息
     * BIO的特点就是输入输出不能进行同时进行
     *
     * @param client Client Socket
     * @param msg    要广播的消息
     * @throws IOException 异常
     */
    public void multicast(Socket client, String msg) throws IOException {
        for (Socket clientSocket : clientSockets.keySet()) {
            if (clientSocket != client) {
                PrintWriter writer = SocketIoUtils.getWriter(clientSocket);
                writer.println(msg);
                writer.flush();
            }
        }
    }
}
