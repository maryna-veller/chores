package com.mveller.chores.repository.services;

import com.mveller.chores.repository.data.Account;

/**
 * Created by Maryna on 1/27/16.
 */
public interface AccountService {
    Account getAccount(Long id);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    Long deleteAccount(Long id);
}
