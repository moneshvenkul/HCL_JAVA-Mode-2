package com.pack.AccountConsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

//protected Logger logger = Logger
// .getLogger (AccountController.class.getName());

	@Autowired
	AccountRepository accountRepository;

	@RequestMapping("/accounts")
	public Account[] all() {

//logger.info("accounts-microservice all() invoked");
		List<Account> accounts = (List<Account>) accountRepository.findAll();

//logger.info("accounts-microservice all() found: + 
		return accounts.toArray(new Account[accounts.size()]);
	}

	@RequestMapping("/accounts/{id}")
	public Account byId(@PathVariable("id") Integer id) {

//logger.info("accounts-microservice byId() invoked: " + id);

		Account account = accountRepository.findOne(id);
//logger.info("accounts-microservice byId() found: + account);

		return account;

	}
}
