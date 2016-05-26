package com.stream.mocks.account;

/**
 * An interface for all the manager implementations.
 *
 * @version $Id: AccountManager.java 503 2009-08-16 17:47:12Z paranoid12 $
 */
public interface AccountManager
{
    /**
     * A method to find an account by the given userId.
     *
     * @param userId
     * @return
     */
    Account findAccountForUser( String userId );

    /**
     * A method to update the given accout.
     *
     * @param account
     */
    void updateAccount( Account account );


}
