package com.revature.model.entities;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private String name;
	private String userName;
	private String address;
	private String email;
	private String pasword;
	
		
	public User() {
		super();
	}
	public User(int id, String name, String userName, String address,String email , String pasword) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.address = address;
		this.email = email;		
		this.pasword = pasword;
	}

	
	

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", address=" + address + ", email="
				+ email + ", pasword=" + pasword + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pasword == null) ? 0 : pasword.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pasword == null) {
			if (other.pasword != null)
				return false;
		} else if (!pasword.equals(other.pasword))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
