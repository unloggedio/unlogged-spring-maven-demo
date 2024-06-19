package org.unlogged.demo.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

@RestController
@RequestMapping("/responseEntity")
public class ResponseEnitityOps {

    public ResponseEntity<String> getOkString() {
        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<User> getOkUser() {
        return ResponseEntity.ok(new User(1, "u1", "p1", "e1"));
    }

    public ResponseEntity<User> getUserOf() {
        return ResponseEntity.of(ProblemDetail.forStatus(200)).build();
    }

    public ResponseEntity<User> createWithCode() {
        return new ResponseEntity(new User(1, "u1", "p1", "e1"), HttpStatusCode.valueOf(201));
    }
}
