package com.cdcb.pruebatecnica1_softlond;

import java.util.List;

import com.cdcb.pruebatecnica1_softlond.controllers.AccountController;
import com.cdcb.pruebatecnica1_softlond.controllers.UserController;
import com.cdcb.pruebatecnica1_softlond.domain.Account;
import com.cdcb.pruebatecnica1_softlond.domain.Transaction;
import com.cdcb.pruebatecnica1_softlond.domain.User;
import com.cdcb.pruebatecnica1_softlond.repositories.AccountRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.IRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.TransactionRepository;
import com.cdcb.pruebatecnica1_softlond.repositories.UserRepository;
import com.cdcb.pruebatecnica1_softlond.services.AccountService;
import com.cdcb.pruebatecnica1_softlond.services.IService;
import com.cdcb.pruebatecnica1_softlond.services.TransactionService;
import com.cdcb.pruebatecnica1_softlond.services.UserService;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App 
{
    public static void main( String[] args )
    {

        IRepository<User> userRepository = new UserRepository("banco.db");
        IService<User> userService = new UserService(userRepository);
        userService.removeDDL();
        userService.createDDL();

        User user = new User("David", "Cruz", "1");
        userService.save(user);
        List<User> users = userService.getAll();
        System.out.println(users.toString());

        IRepository<Account> accountRepository = new AccountRepository("banco.db");
        IService<Account> accountService = new AccountService(accountRepository);
        accountService.removeDDL();
        accountService.createDDL();

        Account account = new Account("123", 100, "Cruz", 1);
        accountService.save(account);
        System.out.println(accountService.getOne(1));

        List<Account> accounts = ((AccountService)accountService).getByUser(1);
        System.out.println(accounts.toString());

        IRepository<Transaction> transactionRepository = new TransactionRepository("banco.db");
        IService<Transaction> transactionService = new TransactionService(transactionRepository, accountRepository);
        transactionService.removeDDL();
        transactionService.createDDL();
        

        Server server = new Server(9090);
        server.setHandler(new DefaultHandler());

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(UserController.class, "/api/user/*");
        context.addServlet(AccountController.class, "/api/account/*");
        context.addServlet(UserController.class, "/api/transaction/*");
        server.setHandler(context);

        try{
            server.start();
            server.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
