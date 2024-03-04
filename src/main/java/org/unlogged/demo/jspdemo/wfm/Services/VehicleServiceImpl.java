package org.unlogged.demo.jspdemo.wfm.Services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.Dao.UsersRepository;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;

@Configuration
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserProfile(String username) {
        User u = usersRepository.getUserByUsername(username);
        u.setPassword("temp-pass");
        return u;
    }
}
