package com.example.login.service;

import com.example.login.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}