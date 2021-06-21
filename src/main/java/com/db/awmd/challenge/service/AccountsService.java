package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.repository.AccountsRepository;
import lombok.Getter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

  @Getter
  private final AccountsRepository accountsRepository;

  @Autowired
  public AccountsService(AccountsRepository accountsRepository) {
    this.accountsRepository = accountsRepository;
  }

  public void createAccount(Account account) {
    this.accountsRepository.createAccount(account);
  }

  public Account getAccount(String accountId) {
    return this.accountsRepository.getAccount(accountId);
  }
  
  public Transaction TransferMoney(
          TransferBalanceRequest transferBalanceRequest
  ) {
      String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
      String toAccountNumber = transferBalanceRequest.getToAccountNumber();
      BigDecimal amount = transferBalanceRequest.getAmount();
      Account fromAccount = accountsRepository.findByAccountNumberEquals(fromAccountNumber);
      Account toAccount = accountsRepository.findByAccountNumberEquals(toAccountNumber);
      if(fromAccount.getBalance().compareTo(BigDecimal.ONE) == 1
              && fromAccount.getBalance().compareTo(amount) == 1
      ){
          fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
          accountsRepository.save(fromAccount);
          toAccount.setBalance(toAccount.getBalance().add(amount));
          accountsRepository.save(toAccount);
      }
      return null;
  }
}
