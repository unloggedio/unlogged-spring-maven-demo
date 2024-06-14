package org.unlogged.demo.models.mapper.dto;

public class UserModelMiniDto {
    private long id;
    private String username;

    public UserModelMiniDto(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserModelMiniDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
