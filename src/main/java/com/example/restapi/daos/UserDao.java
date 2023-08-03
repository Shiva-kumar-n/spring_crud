package com.example.restapi.daos;

import org.bson.types.ObjectId;

import com.example.restapi.entities.User;
import com.example.restapi.requests.CreateRequest;
import com.example.restapi.responses.CreateUserResponse;
import com.example.restapi.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public User fetchUserById(String id){
        return mongoTemplate.findById(new ObjectId(id),User.class);
    }

    public void deleteById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, User.class);
    }

    public void updateById(String id,String updatedName, String updatedPassword)
    {
        Update update = new Update();
        update.set("username",updatedName);
        update.set("password",updatedPassword);
        update.set("lastupdated", System.currentTimeMillis());
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.updateFirst(query, update, User.class);
    }
}
