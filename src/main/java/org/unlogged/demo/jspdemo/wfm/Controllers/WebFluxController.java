//package org.unlogged.demo.jspdemo.wfm.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
//import org.unlogged.demo.jspdemo.wfm.Services.UserService;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//@RestController
//public class WebFluxController {
//
//    @Autowired
//    private UserService userService;
//
//    public Mono<User> getMonoUser(String username) {
//        return Mono.just(userService.getUser(username));
//    }
//
//    public User getUser(String username) {
//        return userService.getUser(username);
//    }
//
//    public ResponseEntity<User> respUser() {
//        return ResponseEntity.ok(new User());
//    }
//
//    public ResponseEntity<Mono<User>> response() {
//        return ResponseEntity.ok(Mono.just(new User()));
//    }
//
//    public List<User> listOfUsers() {
//        List<User> users = new ArrayList<>();
//        users.add(new User());
//        return users;
//    }
//
//    public Map<Integer, User> mapOfUsers() {
//        Map<Integer, User> userMap = new TreeMap<>();
//        userMap.put(1, new User());
//        return userMap;
//    }
//
//    public Flux<User> getFluxUser(String username) {
//        return Flux.fromArray(userService.getAllUsers().toArray(new User[0]));
//    }
//
//    private Mono<User> returnTheSame(Mono<User> userMono) {
//        return userMono;
//    }
//}
