package com.owen.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author OwenHuang
 * @since 2022/11/12 22:42
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8888));
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                serverChannel.accept(attachment, null);
                try {
                    System.out.println("Remote address: " + client.getRemoteAddress());
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    client.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloAioClient".getBytes()));
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
        while (true) {
            Thread.sleep(1000);
        }
    }
}
