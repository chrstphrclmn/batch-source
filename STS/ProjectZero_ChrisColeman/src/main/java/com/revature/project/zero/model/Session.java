package com.revature.project.zero.model;

public class Session {
	
	private Account account;
	private Login login;
	
	
	public Session(Account account, Login login) {
		super();
		this.account = account;
		this.login = login;
	}
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	

}
