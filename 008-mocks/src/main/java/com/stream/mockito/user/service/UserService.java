package com.stream.mockito.user.service;

import java.util.List;

import com.stream.mockito.user.domain.User;


public interface UserService {

    User getUser(String id);
    List<User> getAllUser();
    void addRoleToUser(String userId, String... roles);

}
