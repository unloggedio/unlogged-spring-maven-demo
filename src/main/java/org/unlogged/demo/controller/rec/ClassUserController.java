package org.unlogged.demo.controller.rec;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

@RestController
@RequestMapping("/classuser")
public class ClassUserController {

    @RequestMapping("/cu")
    private User setAndGetUser() {
        User u = new User(1, "a", "a", "a");
        ClassUserChild classUserChild = new ClassUserChild(u);
        classUserChild.setUser(new User(2, "b", "b", "b"));
        return classUserChild.getUser();
    }
}
