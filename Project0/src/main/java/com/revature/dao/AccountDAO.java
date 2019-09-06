package com.revature.dao;



public interface AccountDAO {
	public int createAccount(String userName, String pass, int accountNum,double accountBal);
	public double accountBalance(String userName, String passWord);
	public double depositAccount(String userName, String passWord, double amount);
	public int withdrawAccount(String userName, String passWord, double amount);
	public int accountID(String user,String pass);
}
