package com.cmvrs.dao.inte;

import java.util.List;

import com.cmvrs.model.Account;

public interface AccountDao {
	Long saveAccount(Account account);
	Account getAccount(Long account);
	List<Account> findAccountByName(String name);
	List<Account> getAllAccounts();
	void updateAccount(Account account);
}
