package com.owen.io.aio;

import com.owen.io.ProjectThreadPool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author OwenHuang
 * @since 2022/11/13 10:58
 */
public class ServerWithThreadGroup {
    public static void main(String[] args) throws IOException {
        AsynchronousChannelGroup threadPoolGroup = AsynchronousChannelGroup.withThreadPool(ProjectThreadPool.getInstance());
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(threadPoolGroup);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                serverSocketChannel.accept(attachment, this);
                try {
                    System.out.println("Remote address:" + client.getRemoteAddress());
                    ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
                    client.read(readByteBuffer, readByteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println("Read content: " + new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("Hello aio client".getBytes()));
                        }

                        @Override
                        public void failed(Throwable throwable, ByteBuffer attachment) {
                            throwable.printStackTrace();
                        }
                    });
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable throwable, Object attachment) {
                throwable.printStackTrace();
            }
        });
    }
}