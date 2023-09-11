package com.project.blog.service;

import com.project.blog.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User User);

    User getUserById(Long id);

    User updateUser(User User);

    void deleteUserById(Long id);
}
