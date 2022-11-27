package com.owen.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author OwenHuang
 * @since 2022/11/12 20:33
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello,Server".getBytes());
            outputStream.flush();
            System.out.println("Waiting for server write back....");
            byte[] bytes = new byte[1024];
            int length = socket.getInputStream().read(bytes);
            System.out.println("Read message is: " + new String(bytes, 0, length));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}