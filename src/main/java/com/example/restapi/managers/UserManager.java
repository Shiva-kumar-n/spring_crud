package com.example.restapi.managers;

import com.example.restapi.daos.UserDao;
import com.example.restapi.entities.User;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.requests.UpdateRequest;
import com.example.restapi.responses.CreateUserResponse;
import com.example.restapi.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager {


    private UserDao userDao;



    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;

    }


    public CreateUserResponse createUser(CreateRequest createRequest){

        if(createRequest.isValid()){
            createRequest.setUpdatedphone("+91 "+createRequest.getPhonenumber());
            createRequest.setIsverfied(false);
            return userDao.createUser(createRequest);
        }
        return new CreateUserResponse(null,false,null);
    }


    public List<GetUserResponse> findAll()
    {
        List<User> userList = userDao.fetchUsers();
        List<GetUserResponse> responseList=new ArrayList<>();
        for(User user: userList){
            responseList.add(new GetUserResponse(user.getId(),user.getUsername(),user.getAge(),user.getUpdatedphone()));
        }
        return responseList;
    }

    public GetUserResponse findUserById(String id){
        User user = userDao.fetchUserById(id);
        return new GetUserResponse(user.getId(),user.getUsername(),user.getAge(),user.getUpdatedphone());
    }

    public boolean deleteUserById(String id)
    {
        userDao.deleteById(id);
        return true;
    }

    public String updateUserById(@RequestBody UpdateRequest updateRequest) {
        String id = updateRequest.getId();
        String updatedUsername = updateRequest.getUsername();
        String updatedPassword = updateRequest.getPassword();
        userDao.updateById(id,updatedUsername,updatedPassword);
        return String.format("Updated User with id : %s",id);
    }
}
