package com.mveller.convertor;

import com.mveller.chores.repository.data.Account;
import com.mveller.dto.AccountDto;
import org.springframework.stereotype.Component;

/**
 * Created by Maryna on 2/1/16.
 */
@Component
public class AccountConverter {
    public Account fromDto(final AccountDto accountDto){
        return new Account(accountDto.getFirstName(), accountDto.getLastName(), accountDto.getEmail(), accountDto.getPassword());
    }

    public AccountDto toDto(final Account account){
        return new AccountDto(account.getFirstName(), account.getLastName(), account.getEmail(), account.getPassword(), account.getId());
    }
}
