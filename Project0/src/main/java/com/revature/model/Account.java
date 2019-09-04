package com.revature.model;

public class Account {
	private int id;
	private String userName;
	private String passWord;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getiD() {
		return id;
	}
	public void setiD(int iD) {
		this.id = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [iD=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

	public Account(int id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}
	public Account(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
}
