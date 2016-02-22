package com.mveller.chores.web;

import com.mveller.chores.repository.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Maryna on 1/27/16.
 */
@Configuration
@ComponentScan
public class Test {
    @Autowired
    private AccountService accountService;

    public void test(){
        System.out.println(accountService.getAccount(1l).getFirstName());
    }
}
