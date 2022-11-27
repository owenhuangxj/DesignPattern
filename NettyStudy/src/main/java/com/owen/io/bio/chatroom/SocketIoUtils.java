package com.owen.io.bio.chatroom;/**
 * @Author：Owen
 * @Package：com.owen.io.bio.chatroom
 * @Project：NettyStudy
 * @name：IoUtils
 * @Date：2022/11/20 15:41
 * @Filename：IoUtils
 */

import java.io.*;
import java.net.Socket;

/**
 * @author OwenHuang
 * @since 2022/11/20 15:41
 */
public class SocketIoUtils {
    public static BufferedReader getReader(Socket socket) {
        BufferedReader reader = null;
        try {
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            reader = new BufferedReader(isr);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return reader;
    }

    public static PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    public static void send(Socket socket, String msg) throws IOException {
        PrintWriter writer = getWriter(socket);
        writer.print(msg);
    }
}
