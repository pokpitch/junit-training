package com.stream.mockito.user.service;

import com.stream.mockito.user.domain.User;


public interface UserService {

    User getUser(String id);
    void addRoleToUser(String userId, String... roles);

}
