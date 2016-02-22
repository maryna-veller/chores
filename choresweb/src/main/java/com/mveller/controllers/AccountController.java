package com.mveller.controllers;

import com.mveller.chores.repository.data.Account;
import com.mveller.chores.repository.services.AccountService;
import com.mveller.convertor.AccountConverter;
import com.mveller.dto.AccountDto;
import com.mveller.dto.ValidationErrorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Maryna on 2/1/16.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountConverter accountConverter;
    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public AccountDto createAccount(@RequestBody @Valid AccountDto accountDto){
        Account account = accountConverter.fromDto(accountDto);
        Account createdAccount = accountService.createAccount(account);
        return accountConverter.toDto(createdAccount);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public AccountDto updateAccount(@RequestBody @Valid AccountDto accountDto, @PathVariable Long id){
        Account account = accountConverter.fromDto(accountDto);
        account.setId(id);
        Account updatedAccount = accountService.updateAccount(account);
        return accountConverter.toDto(updatedAccount);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AccountDto getAccount(@PathVariable Long id){
        Account retrievedAccount = accountService.getAccount(id);
        return accountConverter.toDto(retrievedAccount);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldError> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return fieldErrors;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String processError(RuntimeException ex) {


        return "{\"error\":\"345\"}";
    }

}
