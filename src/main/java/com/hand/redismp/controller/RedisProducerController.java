package com.hand.redismp.controller;

import com.hand.redismp.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *生产者->发送消息
 * @author PC
 */

@RestController
@RequestMapping("/producer")
public class RedisProducerController {

    @Autowired
    RedisClient redisClient;

    /** 公共配置 */
    private final static String SUCCESS = "success";
    private final static String MESSAGE = "testmq";
    private static final List<String> list;

    static {
        list = Arrays.asList(new String[]{"hand", "myj", "shanghai"});
    }

    /**
     * 消息发送API
     * @return
     */
    @RequestMapping("/sendMessage")
    public String sendMessage() {
        for (String message : list) {
            redisClient.lpush(MESSAGE, message);
        }
        return SUCCESS;
    }

}
