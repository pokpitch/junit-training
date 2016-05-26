package com.stream.mocks.account;

public interface AccountManager {
    /**
     * A method to find an account by the given userId.
     *
     * @param userId
     * @return
     */
    Account findAccountForUser(String userId);

    /**
     * A method to update the given accout.
     *
     * @param account
     */
    void updateAccount(Account account);


}
