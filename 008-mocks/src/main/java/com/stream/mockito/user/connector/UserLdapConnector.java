
package com.stream.mockito.user.connector;

import java.util.List;

import com.stream.mockito.user.domain.User;

public interface UserLdapConnector {

    User getUser(String id);
    List<User> getAllUser(); 
}
