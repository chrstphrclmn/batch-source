package com.revature.bankingapp.sysoutgui.dao;

import java.util.List;
import java.util.Optional;

import com.revature.bankingapp.sysoutgui.model.Account;

public interface AccountDAO {

	Optional<Account> findById(long id);
	
	Optional<Account> findByUsername(String username);

	List<Account> findAll();

	void save(Account account);

	void update(Account account, String[] params);

	void delete(Account account);
}
