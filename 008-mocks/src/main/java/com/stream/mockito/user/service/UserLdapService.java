package com.stream.mockito.user.service;

import java.util.Arrays;

import com.stream.mockito.user.connector.UserLdapConnector;
import com.stream.mockito.user.domain.User;
import com.stream.mockito.user.repository.UserRoleRepository;

public class UserLdapService implements UserService {

    private final UserLdapConnector userLdapConnector;
    private final UserRoleRepository userRoleRepository;

    public UserLdapService(UserLdapConnector userLdapConnector, UserRoleRepository userRoleRepository) {
        this.userLdapConnector = userLdapConnector;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(String id) {

        final User user = this.userLdapConnector.getUser(id);

        if (user == null) {
            throw new RuntimeException(String.format("User '%s' not found.", id));
        }
        user.getRoles().addAll(this.userRoleRepository.getRolesForUser(id));

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRoleToUser(String userId, String... roles) {
        final User user = getUser(userId);

        for (String role : roles) {
            if (user.getRoles().contains(role)) {
                throw new RuntimeException(String.format("User '%s' already has role '%s'.", userId, role));
            }
        }
        user.getRoles().addAll(Arrays.asList(roles));
        this.userRoleRepository.addRoleToUser(userId, roles);
    }
}
