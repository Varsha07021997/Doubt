package com.restful.webservices.restfulwebservices.Bean;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Static Filtering
//@JsonIgnoreProperties(value = {"password"})
//Dynamic Filtering
@JsonFilter("UserBeanFilter")
public class UserBean {
    private String  username;
    //@JsonIgnore
    private String  password;
    public UserBean() {
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


    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }


}

