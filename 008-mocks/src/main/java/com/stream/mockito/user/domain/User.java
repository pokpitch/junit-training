package com.stream.mockito.user.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String id;
    private final String firstName;
    private final String lastName;
    private final Set<String> roles = new HashSet<String>();

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
