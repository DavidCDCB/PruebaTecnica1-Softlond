package com.cdcb.pruebatecnica1_softlond;

import com.cdcb.pruebatecnica1_softlond.domain.Account;
import com.cdcb.pruebatecnica1_softlond.repositories.AccountRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;

public class App 
{
    public static void main( String[] args )
    {
        IRepository<Account> accountRepository = new AccountRepository("banco.db");
        accountRepository.createTable();
    }
}
