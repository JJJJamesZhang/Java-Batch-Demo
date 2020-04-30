package com.company.demojavabatch.service;

import com.company.demojavabatch.utils.CacheClient;
import com.company.demojavabatch.vo.LoginResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//@Service
public class UserService {
//    @KafkaListener(topics = "user")
    public void receive(@Payload String message, @Headers MessageHeaders headers) throws JsonProcessingException {
        LoginResult loginResult = LoginResult.jsonStringToLoginResult(message);
        JedisPool jedisPool = CacheClient.getJedisPool();
        try (Jedis jedis = jedisPool.getResource()){
            jedis.setex(loginResult.getUsername(),600,loginResult.getToken());
            System.out.println("success write to redis");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
