package com.JackGuo.controller;

import com.JackGuo.entity.User;
import com.JackGuo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartByUtils {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test02")
    public Object test02(){
        User user = new User("JackGuo", 3);
        redisUtils.set("user",user);
        return redisUtils.get("user");
    }
}
