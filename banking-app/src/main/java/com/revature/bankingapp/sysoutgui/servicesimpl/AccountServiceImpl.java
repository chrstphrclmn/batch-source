package com.revature.bankingapp.sysoutgui.servicesimpl;

import java.util.List;

import com.revature.bankingapp.sysoutgui.dao.AccountDAO;
import com.revature.bankingapp.sysoutgui.daoimpl.AccountDAOImpl;
import com.revature.bankingapp.sysoutgui.model.Account;
import com.revature.bankingapp.sysoutgui.services.AccountService;
import com.revature.bankingapp.sysoutgui.util.ViewUtil;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAOImpl = new AccountDAOImpl();
	private static String newline = ViewUtil.getNewline();
	private static String passwordPolicyMessage = "Password requires:" + newline  + "At least one number " + newline
			+ "At least one lowercase " + newline  + "At least one uppercase letter." + newline
			+  "At least six characters." + newline;
	private static String usernamePolicy = "Invalid username, please use only letters and numbers" + newline;

	public static String getPasswordPolicyMessage() {
		return passwordPolicyMessage;
	}

	public static String getUsernamePolicy() {
		return usernamePolicy;
	}

	public void setAccountDAOImpl(AccountDAO accountDAOImpl) {
		this.accountDAOImpl = accountDAOImpl;
	}

	@Override
	public boolean usernameIsValid(String username) {
		String regex = "[A-Za-z0-9]{3,32}";
		if (username.matches(regex)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean usernameExists(String username) {
		List<Account> accounts = accountDAOImpl.findAll();
		for (Account a : accounts) {
			if (username.equals(a.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean passwordIsValid(String password) {
		String regex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}";
		if (password.matches(regex)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passwordsAreEqual(String password, String psw_repeat) {
		if (password.equals(psw_repeat)) {
			return true;
		}
		return false;
	}

}



