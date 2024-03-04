package org.unlogged.demo.jspdemo.wfm;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserInstanceDao implements Dao_Custom<UserInstance> {

    private List<UserInstance> todoList = new ArrayList<>();

    @Override
    public Optional<UserInstance> get(int id) {
        return Optional.ofNullable(todoList.get(id));
    }

    @Override
    public List<UserInstance> getAll() {
        return todoList;
    }

    @Override
    public UserInstance save(UserInstance user) {
        todoList.add(user);
        int index=0;
        if(todoList.size()>0) {
            index = todoList.size() - 1;
        }
        user.setUser_id(index);
        return user;
    }

    @Override
    public void update(UserInstance user) {
        todoList.set(user.getUser_id(), user);
    }

    @Override
    public void delete(UserInstance user) {
        todoList.set(user.getUser_id(), null);
    }
}