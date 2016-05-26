package com.stream.mocks.account;

/**
 * A service that has different methods that we can use. Currently it holds only the transfer method, which transfers
 * money from one account to the other.
 *
 * @version $Id: AccountService.java 503 2009-08-16 17:47:12Z paranoid12 $
 */
public class AccountService
{
    /**
     * The account manager implementation to use.
     */
    private AccountManager accountManager;

    /**
     * A setter method to set the account manager implementation.
     *
     * @param manager
     */
    public void setAccountManager( AccountManager manager )
    {
        this.accountManager = manager;
    }

    /**
     * A transfer method which transfers the amount of money
     * from the account with the senderId to the account of
     * beneficiaryId.
     *
     * @param senderId
     * @param beneficiaryId
     * @param amount
     */
    public void transfer( String senderId, String beneficiaryId, long amount )
    {
        Account sender = this.accountManager.findAccountForUser( senderId );
        Account beneficiary = this.accountManager.findAccountForUser( beneficiaryId );

        sender.debit( amount );
        beneficiary.credit( amount );
        this.accountManager.updateAccount( sender );
        this.accountManager.updateAccount( beneficiary );
    }
}
