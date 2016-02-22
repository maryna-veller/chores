package com.mveller.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Maryna on 2/1/16.
 */

public class AccountDto {
    @NotNull(message = "{error.firstName.required}")
    private String firstName;
    @NotNull(message = "{error.lastName.required}")
    private String lastName;
    @NotNull(message = "{error.email.required}")
  //  @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}", message = "{error.email.regexp}")
    @Email(message = "{error.email.regexp}")
    private String email;
    @NotNull(message = "{error.email.required")
    @Size(min = 4, max = 6, message = "{error.password.size}")
    private String password;
    private long id;

    public AccountDto() {
    }

    public AccountDto(final String firstName, final String lastName, final String email, final String password, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
