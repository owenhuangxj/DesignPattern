package com.owen.builder;
/**
 * @Author：Owen
 * @Package：com.owen.builder
 * @Project：PatternDesign
 * @name：BuilderTest
 * @Date：2022/12/4 0:15
 * @Filename：BuilderTest
 */

import org.junit.jupiter.api.Assertions;

/**
 * @since 2022/12/4 0:15
 * @author OwenHuang
 */
public class BuilderTest {
    public static void main(String[] args) {
        RabbitMqClient rabbitMqClient =
                RabbitMqClient.builder().host("host").port(1250).durable(true).mode(200).connectionTimeout(1000).queue("queue").build();
        Assertions.assertNotNull(rabbitMqClient);
        Assertions.assertEquals(rabbitMqClient.getHost(),"host");
        Assertions.assertEquals(rabbitMqClient.getPort(),1250);
        Assertions.assertEquals(rabbitMqClient.isDurable(),true);
        Assertions.assertEquals(rabbitMqClient.getMode(),200);
        Assertions.assertEquals(rabbitMqClient.getQueue(),"queue");
        Assertions.assertEquals(rabbitMqClient.getConnectionTimeout(),1000);
    }
}
