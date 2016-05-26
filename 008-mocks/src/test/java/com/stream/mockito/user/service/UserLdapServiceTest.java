package com.stream.mockito.user.service;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stream.mockito.user.connector.UserLdapConnector;
import com.stream.mockito.user.domain.User;
import com.stream.mockito.user.repository.UserRoleRepository;
import com.stream.mockito.user.service.UserLdapService;

public class UserLdapServiceTest {

    private static final String USER_ROLE = "USER";
    private static final String USER_ID = "totu2222";
    private final User expectedUser = new User(USER_ID, "Pokpitch", "Patcharadamrongkul");
    private final Set<String> roles = new HashSet<String>();

    @Mock
    private UserLdapConnector ldapConnectorMock;
    @Mock
    private UserRoleRepository userRoleRepositoryMock;

    @InjectMocks
    private UserLdapService service;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        roles.add("ADMIN");
    }

    /**
     * Test method for
     * {@link com.stream.mockito.user.service.UserLdapService#getUser(java.lang.String)}
     * .
     */
    @Test
    public void testGetUserHappyPath() {
        when(ldapConnectorMock.getUser(eq(USER_ID))).thenReturn(expectedUser);
        when(userRoleRepositoryMock.getRolesForUser(USER_ID)).thenReturn(roles);

        final User actualUser = service.getUser(USER_ID);

        InOrder inOrder = inOrder(ldapConnectorMock, userRoleRepositoryMock);
        inOrder.verify(ldapConnectorMock).getUser(USER_ID);
        inOrder.verify(userRoleRepositoryMock).getRolesForUser(USER_ID);
        inOrder.verifyNoMoreInteractions();

        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);
    }

    /**
     * Test method for
     * {@link com.stream.mockito.user.service.UserLdapService#getUser(java.lang.String)}
     * .
     */
    @Test(expected = RuntimeException.class)
    public void testGetUserNotFound() {
        service.getUser(USER_ID);
    }

    /**
     * Test method for
     * {@link com.stream.mockito.user.service.UserLdapService#addRoleToUser(String, String...)}
     * .
     */
    @Test
    public void addRoleToUserBDT() {
        // given
        given(ldapConnectorMock.getUser(USER_ID)).willReturn(expectedUser);
        given(userRoleRepositoryMock.getRolesForUser(USER_ID)).willReturn(roles);

        // when
        this.service.addRoleToUser(USER_ID, USER_ROLE);

        // then
        assertThat(expectedUser.getRoles(), hasItem(USER_ROLE));

        verify(ldapConnectorMock).getUser(USER_ID);
        verify(userRoleRepositoryMock).getRolesForUser(USER_ID);
        verify(userRoleRepositoryMock).addRoleToUser(USER_ID, USER_ROLE);
    }
}
