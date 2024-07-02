package org.unlogged.demo.jspdemo.wfm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.unlogged.demo.jspdemo.wfm.Dao.UsersRepository;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.DeepClass;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.User;
import org.unlogged.demo.jspdemo.wfm.Models.Entities.UserListInfo;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public User getUser(String username) {
        User u = usersRepository.getUserByUsername(username);
        //some comment
        return u;
    }

    public User getUser(long userId) {
        return usersRepository.getUserByUserId(userId);
    }

    public void addUser(User user) {
        usersRepository.save(user);
    }

    public String throwExceptionTest() {
        String a = "aaa ccc";
        String s = "a".split(" ")[1];
        return a;
    }

    public String many(String a, String b, String c, String d) {
        return "some1";
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
    public long getCountOfUsers() {
        return usersRepository.count();
    }

    public UserListInfo getULO() {
        return new UserListInfo(0, usersRepository.findAll());
    }

    public int getNumber() {
        return 14;
    }

    public DeepClass getDeepClassList() {
        List<User> usersList = Arrays.asList(new User(), new User(1, "a", "a", "a"));
        return new DeepClass(usersList);
    }
}

//-javaagent:"/Users/testerfresher/.videobug/videobug-java-agent.jar=i=com.jsp.jspwfm" --add-opens=java.base/java.util=ALL-UNNAMED

