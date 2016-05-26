package com.stream.mockito.user.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;


import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stream.mockito.user.connector.UserLdapConnector;
import com.stream.mockito.user.domain.User;
import com.stream.mockito.user.repository.UserRoleRepository;
import com.stream.mockito.user.service.UserLdapService;


public class UserLdapServiceJUGTest {
    
    private static final String USER_ID = "totu1222";
    @Mock
    private UserLdapConnector ldapConnector;
    @Mock
    private UserRoleRepository roleRepository;
    
    final User expectedUser = new User(USER_ID, "Pokpitch", "Patcharadamrongkul");
    
    Set<String> roles = new HashSet<String>();
    
    @InjectMocks
    private UserLdapService service;
    
    @Before
    public void setUp(){
       MockitoAnnotations.initMocks(this); 
       roles.add("ADMIN");
    }
    
    @Test
    public void testGetUser() {
        mockGetUser();
        
        User actualUser = service.getUser(USER_ID);
        
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);
        
        verifyGetUserMocks();
        verifyZeroInteractions(ldapConnector);
    }

    @Test
    public void getGetAllUser() {
    	mockGetAllUser();
    	List<User> users = service.getAllUser();
    	
    	assertNotNull(users);
    	assertEquals(4, users.size());
    	
    }
    
    private void verifyGetUserMocks() {
        verify(ldapConnector).getUser(USER_ID);
        verify(roleRepository).getRolesForUser(USER_ID);
    }

    private void mockGetUser() {
        when(ldapConnector.getUser(USER_ID)).thenReturn(expectedUser);
        when(roleRepository.getRolesForUser(USER_ID)).thenReturn(roles);
    }
    
    private void mockGetAllUser() {
    	when(ldapConnector.getAllUser()).thenReturn(asList(
    			new User("1", "Pokpitch", "Patcharadamrongkul"),
    			new User("2", "Niphon", "Jobsri"), 
    			new User("3", "Darth", "Vader"),
    			new User("4", "Luke", "Skywalker")
    			));
    }
    
    @Test (expected = RuntimeException.class)
    public void testGetUserNotFound() {
        User actualUser = service.getUser(USER_ID);
    }
    
    @Test (expected = RuntimeException.class)
    public void testAddRoleToUserExistingRole() {
        mockGetUser();
        
        service.addRoleToUser(USER_ID, "ADMIN");
    }
    
    @Test
    public void testAddRoleToUserHappyPath() {
        mockGetUser();
        
        Set<String> roles = new HashSet<String>();
        roles.add("ADMIN");
        when(roleRepository.getRolesForUser(USER_ID)).thenReturn(roles);
        
        service.addRoleToUser(USER_ID, "USER");
        
        verifyGetUserMocks();
        verify(roleRepository).addRoleToUser(USER_ID, "USER");
    }
    
}
