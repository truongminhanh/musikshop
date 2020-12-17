package com.example.login.service;
// UserServiceIF ... CustomerServiceIF

import com.example.login.model.User;

public interface SecurityService {

    boolean isAuthenticated();
    void autoLogin(String username, String password);

    public void createUser(User user);
    public User login(String username,String password);
    public User findByUsername(String username);
    public void registerNewUser(User user);
}