package org.unlogged.demo.jspdemo.wfm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

public interface UsersRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM Users u WHERE u.username = :username", nativeQuery = true)
    public User getUserByUsername(String username);
}
