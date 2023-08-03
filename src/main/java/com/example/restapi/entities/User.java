package com.example.restapi.entities;

import com.example.restapi.requests.CreateRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;


@Document(collection = "studentsdata")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private int age;
    private Long phonenumber;
    private String email;
    private boolean isverfied;
    private String updatedphone;
//    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
//    private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
//    private String updatedBy = "System";



    public void setValueUsingCreateRequest(CreateRequest createRequest){
        this.username = createRequest.getUsername();
        this.password = createRequest.getPassword();
        this.age = createRequest.getAge();
        this.phonenumber = createRequest.getPhonenumber();
        this.isverfied = createRequest.isIsverfied();
        this.email = createRequest.getEmail();
        this.updatedphone = createRequest.getUpdatedphone();
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", isverfied=" + isverfied +
                ", updatedphone='" + updatedphone + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsverfied() {
        return isverfied;
    }

    public void setIsverfied(boolean isverfied) {
        this.isverfied = isverfied;
    }

    public String getUpdatedphone() {
        return updatedphone;
    }

    public void setUpdatedphone(String updatedphone) {
        this.updatedphone = updatedphone;
    }










    public String getId(){
        return this.id;
    }
}
