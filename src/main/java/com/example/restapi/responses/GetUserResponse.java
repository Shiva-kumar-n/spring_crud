package com.example.restapi.responses;

import org.springframework.stereotype.Component;


public class GetUserResponse {
    private String id;
    private String username;
    private int age;
    private String updatedphone;

    public GetUserResponse(String id, String username, int age, String updatedphone) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.updatedphone = updatedphone;
    }

    @Override
    public String toString() {
        return "GetUserResponse{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", updatedphone='" + updatedphone + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUpdatedphone() {
        return updatedphone;
    }

    public void setUpdatedphone(String updatedphone) {
        this.updatedphone = updatedphone;
    }
}
