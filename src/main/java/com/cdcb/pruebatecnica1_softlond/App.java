package com.cdcb.pruebatecnica1_softlond;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.domain.Account;
import com.cdcb.pruebatecnica1_softlond.repositories.AccountRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;
import com.cdcb.pruebatecnica1_softlond.services.AccountService;
import com.cdcb.pruebatecnica1_softlond.services.IService;

public class App 
{
    public static void main( String[] args )
    {
        IRepository<Account> accountRepository = new AccountRepository("banco.db");
        accountRepository.createTable();
        IService<Account> accountService = new AccountService(accountRepository);
        
        List<Account> accounts = accountService.getAll();
        System.out.println(accounts.toString());
    }
}
