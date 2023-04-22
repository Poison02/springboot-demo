package cdu.zch.demo09redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Zch
 **/
@Configuration
public class RedisConfig {

    /**
     * 编写我们自己的redis配置类
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);
        // Json序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // String序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key 采用String序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String序列化 方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
