package com.example.restapi.controllers;


import com.example.restapi.managers.UserManager;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.responses.CreateUserResponse;
import com.example.restapi.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/user/getSingleUser",method = RequestMethod.GET)
    public GetUserResponse getSingleUser(@RequestParam(name = "id") String id) {
        return userManager.findUserById(id);
    }

    @RequestMapping(value = "/user/deleteUser",method = RequestMethod.GET)
    public String deleteUser(@RequestParam(name = "id") String id){
        if(userManager.deleteUserById(id)){
            return String.format("User with id %s removed",id);
        }
        else {
            return "Some Error Occured";
        }
    }
}
