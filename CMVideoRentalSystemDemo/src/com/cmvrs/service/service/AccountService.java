package com.cmvrs.service.service;

import java.util.List;

import com.cmvrs.model.Account;

public interface AccountService {

	Long saveAccount(Account account);
	Account getAccount(Long account);
	List<Account> findAccountByName(String name);
	List<Account> getAllAccounts();
	void updateAccount(Account account);
}
