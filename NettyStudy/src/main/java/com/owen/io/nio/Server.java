package com.owen.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author OwenHuang
 * @since 2022/11/12 20:47
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 打开ServerSocket通道
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            // 设置阻塞状态为非阻塞
            socketChannel.configureBlocking(false);
            System.out.println("Server started,listening on: " + socketChannel.getLocalAddress());
            // 获取ServerSocket
            ServerSocket serverSocket = socketChannel.socket();
            // 绑定监听地址
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
            // 打开一个选择器：NIO的大管家
            Selector selector = Selector.open();
            // 将通道注册给指定的选择器，对SelectionKey.OP_ACCEPT 感兴趣
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                // 选择准备好的IO操作的SelectionKey
                selector.select();
                // 阻塞
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    // 先移除再做处理
                    iterator.remove();
                    // 处理
                    handle(selectionKey);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param selectionKey SelectionKey
     */
    private static void handle(SelectionKey selectionKey) {
        // 处理接受
        if (selectionKey.isAcceptable()) {
            try {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
        // 如果可读：先将数据读取出来，读取完之后写数据
        if (selectionKey.isReadable()) {
            SocketChannel socketChannel = null;
            try {
                socketChannel = (SocketChannel) selectionKey.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                byteBuffer.clear();
                // 读数据
                int length = socketChannel.read(byteBuffer);
                if (length != -1) {
                    System.out.println(new String(byteBuffer.array(), 0, length));
                }
                // 写数据到客户端
                ByteBuffer bufferToWrite = ByteBuffer.wrap("Hello nio client......".getBytes());
                socketChannel.write(bufferToWrite);
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                if (socketChannel != null) {
                    try {
                        socketChannel.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}