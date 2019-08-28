package com.revature.bankingapp.sysoutgui.dao;

import java.util.List;
import java.util.Optional;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public interface SubAccountDAO {

	Optional<SubAccount> findById(long id);

	List<SubAccount> findAll();

	void save(SubAccount subAccount);

	void update(SubAccount subAccount, String[] params);

	void delete(SubAccount subAccount);
}
