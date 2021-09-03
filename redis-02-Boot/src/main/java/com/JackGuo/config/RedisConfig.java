package com.JackGuo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<Object, Object> getRedisTemplate(RedisConnectionFactory factory){

        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
//       json序列化配置
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om=new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectJackson2JsonRedisSerializer.setObjectMapper(om);
//        String类型的序列化
        StringRedisSerializer stringRedisTemplate=new StringRedisSerializer();
        template.setKeySerializer( stringRedisTemplate);
        template.setHashKeySerializer( stringRedisTemplate);
        template.setValueSerializer(objectJackson2JsonRedisSerializer);
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

}
