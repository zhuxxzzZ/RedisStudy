package com.JackGuo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.BitSet;

public class JedisMulti {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.73.129",6379);
        jedis.flushDB();
        Transaction ml = jedis.multi();
        try {
            ml.set("name","JackGuo");
            int a=1/0;
            ml.set("age","12");
            ml.exec();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("运行是出现异常");

        }finally {
            System.out.println(jedis.get("name"));
            System.out.println(jedis.get("age"));

        }

        jedis.close();


    }
}
