package com.stream.mockito.user.repository;

import java.util.Set;

public interface UserRoleRepository {

    Set<String> getRolesForUser(String userId);

    void addRoleToUser(String userId, String... roles);
}
