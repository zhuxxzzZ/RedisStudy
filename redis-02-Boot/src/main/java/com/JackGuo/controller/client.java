package com.JackGuo.controller;

import com.JackGuo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class client {

    @Autowired
    @Qualifier("getRedisTemplate")
    private RedisTemplate redisTemplate;



    @RequestMapping("/test1")
    public Object Test() {
        User user = new User("JackGuo", 3);
        redisTemplate.opsForValue().set("user", user);
        Object name = redisTemplate.opsForValue().get("user");
        System.out.println(name);

        return name;
    }


}
