package org.unlogged.demo.security.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.unlogged.demo.security.model.User;

@Repository
public class UserRepository {
    @Value("${userpassword}")
    private String fixedPass;
    public User findUserByEmail(String email) {
        User user = new User(email, fixedPass);
        user.setFirstName("User firstname");
        user.setLastName("User lastname");
        return user;
    }
}
