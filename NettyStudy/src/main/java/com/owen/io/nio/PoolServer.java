package com.owen.io.nio;

import com.owen.io.ProjectThreadPool;

import java.io.ByteArrayOutputStream;
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
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author OwenHuang
 * @since 2022/11/12 21:52
 */
public class PoolServer {

    private Selector selector;

    private ThreadPoolExecutor threadPool = ProjectThreadPool.getInstance();

    private void initServer(int port) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
            this.selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器端服务启动......");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void listen() {
        while (true) {
            try {
                this.selector.select();
                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(this.selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        selectionKey.interestOps(selectionKey.interestOps() & ~SelectionKey.OP_READ);
                        threadPool.execute(new ThreadHandlerChannel(selectionKey));
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PoolServer poolServer = new PoolServer();
        poolServer.initServer(8000);
        poolServer.listen();
    }

    private class ThreadHandlerChannel implements Runnable {
        private SelectionKey selectionKey;

        public ThreadHandlerChannel(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int size = 0;
                while ((size = socketChannel.read(byteBuffer)) > 0) {
                    byteBuffer.flip();
                    byteArrayOutputStream.write(byteBuffer.array(), 0, size);
                    byteBuffer.clear();
                }
                byteArrayOutputStream.close();

                byte[] content = byteArrayOutputStream.toByteArray();

                ByteBuffer bufferToWrite = ByteBuffer.allocate(content.length);
                bufferToWrite.put(content);
                bufferToWrite.flip();
                socketChannel.write(bufferToWrite);
                if (size == -1) {
                    socketChannel.close();
                } else {
                    selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_READ);
                    selectionKey.selector().wakeup();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
