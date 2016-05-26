package com.stream.mocks.account;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.stream.mocks.account.Account;
import com.stream.mocks.account.AccountService;

/**
 * A test-case to test the AccountService class.
 * We use the custom mock AccountManager that we
 * implemented.
 *
 * @version $Id: TestAccountService.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestAccountService
{
    @Test
    public void testTransferOk()
    {
        MockAccountManager mockAccountManager = new MockAccountManager();
        Account senderAccount = new Account( "1", 200 );

        Account beneficiaryAccount = new Account( "2", 100 );
        mockAccountManager.addAccount( "1", senderAccount );
        mockAccountManager.addAccount( "2", beneficiaryAccount );

        AccountService accountService = new AccountService();
        accountService.setAccountManager( mockAccountManager );
        accountService.transfer( "1", "2", 50 );

        assertEquals( 150, senderAccount.getBalance() );
        assertEquals( 150, beneficiaryAccount.getBalance() );
    }
}
