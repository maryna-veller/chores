package com.mveller.chores.repository.services.impl;

import com.mveller.chores.repository.data.Account;
import com.mveller.chores.repository.services.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Maryna on 1/27/16.
 */
@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private static final Logger logger = LogManager.getLogger();

    public Account getAccount(Long id) {
        Account account  = accountRepository.findOne(id);
        if (account == null){
            throw new RuntimeException("account not found");
        }
        logger.info("Account with id {} found", id);
        return account;
    }

    public Account createAccount(final Account account) {
        Account newAccount = accountRepository.save(account);
        logger.info("Account {} for {} {} was created ", newAccount.getId(), newAccount.getFirstName(), newAccount.getLastName());
        return newAccount;
    }

    public Account updateAccount(Account account) {
        getAccount(account.getId());
        accountRepository.save(account);
        return account;
    }

    public Long deleteAccount(Long id) {
        Account account = getAccount(id);
        accountRepository.delete(account);
        return id;
    }
}
