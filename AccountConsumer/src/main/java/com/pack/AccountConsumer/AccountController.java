package com.pack.AccountConsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	@RequestMapping("/accounts")
    public Account[] all() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accounts.toArray(new Account[accounts.size()]);
    }
   
    @RequestMapping("/accounts/{id}")
    public Account byId(@PathVariable("id") Integer id) {
        Account account= accountRepository.findOne(id);
        return account;
    }
}
