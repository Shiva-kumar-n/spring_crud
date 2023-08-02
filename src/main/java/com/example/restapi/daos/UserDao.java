package com.example.restapi.daos;


import com.example.restapi.entities.User;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.responses.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDao{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserDao(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }


    public List<User> fetchUsers()
    {

        Query query = new Query();
        List<User> userList = mongoTemplate.find(query,User.class);
        return userList;
    }

    public CreateUserResponse createUser(CreateRequest createRequest) {
        User newUser = new User();
        newUser.setValueUsingCreateRequest(createRequest);
        User savedUser = mongoTemplate.save(newUser);
        CreateUserResponse createUserResponse = new CreateUserResponse(savedUser.getUsername(),true,savedUser.getPassword());
        return createUserResponse;
    }

}