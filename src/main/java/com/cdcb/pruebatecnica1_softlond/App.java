package com.cdcb.pruebatecnica1_softlond;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.domain.Account;
import com.cdcb.pruebatecnica1_softlond.domain.User;
import com.cdcb.pruebatecnica1_softlond.repositories.AccountRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.UserRepository;
import com.cdcb.pruebatecnica1_softlond.services.AccountService;
import com.cdcb.pruebatecnica1_softlond.services.IService;
import com.cdcb.pruebatecnica1_softlond.services.UserService;

public class App 
{
    public static void main( String[] args )
    {
        IRepository<Account> accountRepository = new AccountRepository("banco.db");
        IService<Account> accountService = new AccountService(accountRepository);
        accountService.createDDL();
        
        IRepository<User> userRepository = new UserRepository("banco.db");
        IService<User> userService = new UserService(userRepository);
        userService.createDDL();
        
        User user = new User("David", "Cruz", "1");
        userService.save(user);
        List<User> users = userService.getAll();
        System.out.println(users.toString());
    }
}
