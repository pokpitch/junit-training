package com.stream.mocks.account;

import org.junit.Test;

import com.stream.mocks.account.Account;
import com.stream.mocks.account.DefaultAccountManager2;
import com.stream.mocks.configurations.MockConfiguration;

/**
 * A test-case for the DefaultAccountManager class.
 *
 * @version $Id: TestDefaultAccountManager.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestDefaultAccountManager
{

    @Test
    public void testFindAccountByUser()
    {
        MockLog logger = new MockLog();
        MockConfiguration configuration = new MockConfiguration();
        configuration.setSQL( "SELECT * [...]" );
        DefaultAccountManager2 am = new DefaultAccountManager2( logger, configuration );

        @SuppressWarnings("unused")
        Account account = am.findAccountForUser( "1234" );

        // Perform asserts here
        // [�]
    }
}
