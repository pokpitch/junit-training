package com.stream.mocks.account;

import org.apache.commons.logging.Log;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.stream.mocks.account.Account;
import com.stream.mocks.account.DefaultAccountManager2;
import com.stream.mocks.configurations.Configuration;

/**
 * This is another test-case for the DefaultAccountManager class. We use here the Jmock library to mock the logger and
 * the configuration.
 *
 * @version $Id: TestDefaultAccountManagerJMock.java 508 2009-08-16 18:05:18Z paranoid12 $
 */
@RunWith( JMock.class )
public class TestDefaultAccountManagerJMock
{
    Mockery context = new JUnit4Mockery();

    private Configuration configuration;

    private Log logger;

    @Before
    public void setUp()
    {
        configuration = context.mock( Configuration.class );
        logger = context.mock( Log.class );
    }

    @Test
    public void testFindAccountByUser()
    {
        context.checking( new Expectations()
        {
            {
                oneOf (logger).debug("Getting account for user [1234]");

                oneOf (configuration).getSQL( "FIND_ACCOUNT_FOR_USER" );
                will( returnValue( "SELECT ..." ) );
            }
        } );

        DefaultAccountManager2 am = new DefaultAccountManager2( logger, configuration );
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser( "1234" );

        // Perform asserts here
        // [�]
    }
}
