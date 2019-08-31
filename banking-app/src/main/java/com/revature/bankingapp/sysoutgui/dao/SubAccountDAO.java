package com.revature.bankingapp.sysoutgui.dao;

import java.util.List;
import java.util.Optional;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public interface SubAccountDAO {

	Optional<SubAccount> findById(long id);

	List<SubAccount> findAll();

	List<SubAccount> findAllById(long id);

	Long save(SubAccount subAccount);

	void update(SubAccount subAccount);

	void updateTransfer(SubAccount subAccount1, SubAccount subAccount2);

	void delete(SubAccount subAccount);
}
