package com.revature.bankingapp.sysoutgui.services;

import com.revature.bankingapp.sysoutgui.model.SubAccount;

public interface SubAccountService {

	SubAccount updateFunds(SubAccount subAccount, Double funds, String operation);

}
