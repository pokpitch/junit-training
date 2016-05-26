package com.stream.mocks.account;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.stream.mocks.account.Account;
import com.stream.mocks.account.DefaultAccountManager2;
import com.stream.mocks.configurations.Configuration;

/**
 * This is a test-case for the DefualtAccountManager class.
 * We use here the EasyMock library to mock the logger and the
 * configuration classes.
 *
 * @version $Id: TestDefaultAccountManagerEasyMock.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestDefaultAccountManagerEasyMock
{
    private Log logger;

    private Configuration configuration;

    @Before
    public void setUp()
    {
        logger = createMock("logger", Log.class );
        configuration = createMock("configuration", Configuration.class );
    }

    @Test
    public void testFindAccountByUser()
    {
        expect( configuration.getSQL( "FIND_ACCOUNT_FOR_USER" ) ).andReturn( "SELECT .." );
        replay();

        DefaultAccountManager2 am = new DefaultAccountManager2( logger, configuration );

        @SuppressWarnings("unused")
        Account account = am.findAccountForUser( "1234" );

        // Perform asserts here
        // [�]
    }
}
