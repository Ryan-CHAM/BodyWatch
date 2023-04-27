package com.cs411.bodywatchbackend.service;

import com.cs411.bodywatchbackend.model.User;

import java.util.List;

public interface UserService {
    void createUsers(User user);

    void updateUser(User activity);

    List<User> getAllUser();

    User getUserById(int id);

    void deleteUser(int id);

    List<Integer> getAllUserId();
}
