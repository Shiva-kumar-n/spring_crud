package com.example.restapi.requests;

public class CreateRequest {
    private String username;
    private String password;
    private int age;
    private Long phonenumber;
    private String email;
    private String updatedphone ;
    private boolean isverfied;



    public String getUpdatedphone() {
        return updatedphone;
    }

    public void setUpdatedphone(String updatedphone) {
        this.updatedphone = updatedphone;
    }

    public boolean isIsverfied() {
        return isverfied;
    }

    public void setIsverfied(boolean isverfied) {
        this.isverfied = isverfied;
    }


    @Override
    public String toString() {
        return "CreateRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                ", updatedphone='" + updatedphone + '\'' +
                ", isverfied=" + isverfied +
                '}';
    }

    public CreateRequest(String username, String password, int age, Long phonenumber, String email) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
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

    public boolean isValid(){
        if(this.getUsername() == null || this.getPassword() == null || this.getPhonenumber() == null){
            String str = "";
            if(this.getUsername() == null){
                str += "Username Should not be null ";
            }
            if(this.getPassword() == null){
                str += "Password Should not be null ";
            }
            if(this.getPhonenumber() == null){
                str += "Phone Should not be null ";
            }
            throw new IllegalArgumentException(str);
        }
        return true;
    }
}
