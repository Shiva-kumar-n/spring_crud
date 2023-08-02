package com.example.restapi.responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CreateUserResponse {
    private String name;
    private boolean isCreated;
    private String password;


    public CreateUserResponse(String name, boolean isCreated, String password) {
        this.name = name;
        this.isCreated = isCreated;
        this.password = password;
    }

    @Override
    public String toString() {
        return "createUserResponse{" +
                "name='" + name + '\'' +
                ", isCreated=" + isCreated +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
