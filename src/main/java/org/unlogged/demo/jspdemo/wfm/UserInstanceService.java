package org.unlogged.demo.jspdemo.wfm;

import java.util.Optional;

public class UserInstanceService {

    UserInstanceDao dao = new UserInstanceDao();
    public UserInstance saveUser(String username, String password, String email)
    {
        UserInstance instance = new UserInstance(username,password,email);
        return dao.save(instance);
    }

    public UserInstance fetchUser(int userid)
    {
        Optional<UserInstance> instance =  dao.get(userid);
        if(instance.isPresent())
        {
            return instance.get();
        }
        return null;
    }
}
