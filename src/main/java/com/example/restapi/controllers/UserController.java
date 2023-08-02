package com.example.restapi.controllers;


import com.example.restapi.managers.UserManager;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.responses.CreateUserResponse;
import com.example.restapi.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserManager userManager;

    @Autowired
    public UserController(UserManager userManager)
    {
        this.userManager = userManager;
    }

    @RequestMapping(value = "/user/createUser", method = RequestMethod.POST)
    public CreateUserResponse createUser(@RequestBody CreateRequest createRequest)
    {

        return userManager.createUser(createRequest);
    }

    @RequestMapping(value = "/user/getUsers",method = RequestMethod.GET)
    public List<GetUserResponse> getUsers() {

        return userManager.findAll();
    }
}
