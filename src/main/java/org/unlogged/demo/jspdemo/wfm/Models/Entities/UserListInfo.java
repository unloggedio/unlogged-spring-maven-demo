package org.unlogged.demo.jspdemo.wfm.Models.Entities;

import java.util.List;

public class UserListInfo {
    int id = 0;
    List<User> users;

    public UserListInfo(int id, List<User> users) {
        this.id = id;
        this.users = users;
    }

    public UserListInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListInfo{" +
                "id=" + id +
                ", users=" + users +
                '}';
    }
}
