package com.db.awmd.challenge.repository;

import org.springframework.stereotype.Repository;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.DuplicateAccountIdException;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumberEquals(String accountNumber);

  void createAccount(Account account) throws DuplicateAccountIdException;

  Account getAccount(String accountId);

  void clearAccounts();

void save(Account fromAccount);
}


