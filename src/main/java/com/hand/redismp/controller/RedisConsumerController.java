package com.hand.redismp.controller;

import com.hand.redismp.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 消费者->接收消息
 * @author PC
 */
@RestController
@RequestMapping("/consumer")
public class RedisConsumerController {

    @Autowired
    RedisClient redisClient;

    /** 公共配置 */
    private final static String MESSAGE = "testmq";

    /**
     * 接收消息API
     * @return
     */
    @RequestMapping("/receiveMessage")
    public String sendMessage() {
        return (String) redisClient.brpop(MESSAGE, 0, TimeUnit.SECONDS);
    }

}
