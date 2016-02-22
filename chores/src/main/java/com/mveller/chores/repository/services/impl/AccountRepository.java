package com.mveller.chores.repository.services.impl;

import com.mveller.chores.repository.data.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Maryna on 1/28/16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
