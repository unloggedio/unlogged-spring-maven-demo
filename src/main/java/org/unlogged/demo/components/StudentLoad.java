package org.unlogged.demo.components;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import org.unlogged.demo.models.Student;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class StudentLoad {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Student> studentReactiveRedisOperations;
    private static final Logger logger = LoggerFactory.getLogger(StudentLoad.class);

    public StudentLoad(ReactiveRedisConnectionFactory factory,
                       ReactiveRedisOperations<String, Student> studentReactiveRedisOperations) {
        this.factory = factory;
        this.studentReactiveRedisOperations = studentReactiveRedisOperations;
    }

    @PostConstruct
    public void loadData() {
        factory.getReactiveConnection().serverCommands().flushAll().thenMany(
                        Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
                                .map(name -> new Student(UUID.randomUUID().toString(), name))
                                .flatMap(Student -> studentReactiveRedisOperations.opsForValue().set(Student.getId(), Student)))
                .thenMany(studentReactiveRedisOperations.keys("*")
                        .flatMap(studentReactiveRedisOperations.opsForValue()::get))
                .subscribe(e -> logger.warn("Student: " + e));
    }
}
