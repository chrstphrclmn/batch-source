package com.revature.bankingapp.sysoutgui.services;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public interface SubAccountService {

	SubAccount updateFunds(SubAccount subAccount, Double funds, String operation);
	SubAccount transferFunds(SubAccount subAccount1, SubAccount subAccount2, Double funds);

}
