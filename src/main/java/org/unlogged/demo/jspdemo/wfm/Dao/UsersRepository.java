package org.unlogged.demo.jspdemo.wfm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

public interface UsersRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT u.user_id as user_id, u.username as username, u.password as password, u.email as email FROM users u WHERE username = :username", nativeQuery = true)
    public User getUserByUsername(String username);

    @Query(value = "SELECT u.user_id as user_id, u.username as username, u.password as password, u.email as email FROM users u WHERE user_id = :id", nativeQuery = true)
    public User getUserByUserId(long id);
}
