package com.example.restapi.managers;

import com.example.restapi.daos.UserDao;
import com.example.restapi.entities.User;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.responses.CreateUserResponse;
import com.example.restapi.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        createRequest.setUpdatedphone("+91 "+createRequest.getPhonenumber());
        createRequest.setIsverfied(false);

        return userDao.createUser(createRequest);
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
}
