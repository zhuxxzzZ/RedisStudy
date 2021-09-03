package com.JackGuo;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.73.129",6379);
        jedis.set("name","JackGuo");
        jedis.set("age" ,"22");
        System.out.println(jedis.ping());
        System.out.println(jedis.get("name"));
        System.out.println(jedis.keys("*"));
    }
}
