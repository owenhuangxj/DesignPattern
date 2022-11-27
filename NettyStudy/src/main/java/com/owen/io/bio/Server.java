package com.owen.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OwenHuang
 * @since 2022/11/12 20:18
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    handle(socket);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * BIO的特点就是输入输出不能进行同时进行
     * @param socket Socket
     * @throws IOException 异常
     */
    private static void handle(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int length = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, length));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes, 0, length);
        outputStream.flush();
    }
}
