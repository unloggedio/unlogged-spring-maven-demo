//package org.unlogged.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.unlogged.demo.models.Student;
//
//@Configuration
//public class RedisConfig {
//
//    private final String redisHostName = "localhost";
//    private final int redisPort = 6379;
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
//        jedisConFactory.setHostName(redisHostName);
//        jedisConFactory.setPort(redisPort);
//        return jedisConFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//    @Bean
//    public StringRedisTemplate redisStringTemplate() {
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//
//    @Bean
//    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
//        return new LettuceConnectionFactory(redisHostName, redisPort);
//    }
//
//    @Bean
//    ReactiveRedisOperations<String, Student> redisOperations() {
//        Jackson2JsonRedisSerializer<Student> serializer = new Jackson2JsonRedisSerializer<>(Student.class);
//
//        RedisSerializationContext.RedisSerializationContextBuilder<String, Student> builder =
//                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
//
//        RedisSerializationContext<String, Student> context = builder.value(serializer).build();
//
//        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory(), context);
//    }
//}
//
//
