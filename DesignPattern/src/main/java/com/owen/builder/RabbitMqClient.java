package com.owen.builder;
/**
 * @Author：Owen
 * @Package：com.owen.builder
 * @Project：PatternDesign
 * @name：RabbitMqClient
 * @Date：2022/12/4 0:04
 * @Filename：RabbitMqClient
 */

/**
 * 1、Builder类位于目标类的内部，并且使用static修饰
 * 2、目标类定义一个名为builder的静态无参方法,用于返回Builder对象，Builder类定义一个build()方法用于返回目标对象
 * 3、目标类和Builder类的无参构造方法都私有化
 * 4、Builder类对象提供内置各种属性setter，一般以属性名称命名对应的setter方法，setter方法返回Builder对象本身
 * 5、Builder类提供一个build()方法，实现目标对象的创建，目标类提供一个全参的构造方法用于在Builder类中的build()方法调用来返回目标类初始化所有属性的对象
 *
 * @author OwenHuang
 * @since 2022/12/4 0:04
 */
public class RabbitMqClient {

    private String host;
    private int port;
    private int mode;
    private String queue;
    private boolean isDurable;
    private int connectionTimeout;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getMode() {
        return mode;
    }

    public String getQueue() {
        return queue;
    }

    public boolean isDurable() {
        return isDurable;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    private RabbitMqClient() {
    }

    private RabbitMqClient(String host, int port, int mode, String queue, boolean isDurable, int connectionTimeout) {
        this.host = host;
        this.port = port;
        this.mode = mode;
        this.queue = queue;
        this.isDurable = isDurable;
        this.connectionTimeout = connectionTimeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String host;
        private int port;
        private int mode;
        private String queue;
        private boolean isDurable;
        private int connectionTimeout;

        private Builder() {
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder mode(int mode) {
            this.mode = mode;
            return this;
        }

        public Builder queue(String queue) {
            this.queue = queue;
            return this;
        }

        public Builder durable(boolean durable) {
            isDurable = durable;
            return this;
        }

        public Builder connectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public RabbitMqClient build() {
            return new RabbitMqClient(this.host, this.port, this.mode, this.queue, this.isDurable,
                    this.connectionTimeout);
        }
    }

    @Override
    public String toString() {
        return "RabbitMqClient{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", mode=" + mode +
                ", queue='" + queue + '\'' +
                ", isDurable=" + isDurable +
                ", connectionTimeout=" + connectionTimeout +
                '}';
    }
}