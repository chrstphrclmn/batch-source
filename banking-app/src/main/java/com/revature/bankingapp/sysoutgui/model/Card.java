package com.revature.bankingapp.sysoutgui.model;

import java.util.Date;

public class Card {

	private Long id;
	private String type;
	private Long cardNumber;
	private int pin;
	private int securityCode;
	private Date expiryDate;
	private Date subAccountId;
	private Date userId;

	public Card() {
		super();
	}

	public Card(Long id, String type, Long cardNumber, int pin, int securityCode, Date expiryDate, Date subAccountId,
			Date userId) {
		super();
		this.id = id;
		this.type = type;
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.securityCode = securityCode;
		this.expiryDate = expiryDate;
		this.subAccountId = subAccountId;
		this.userId = userId;
	}

	public Card(String type, Long cardNumber, int pin, int securityCode, Date expiryDate, Date subAccountId,
			Date userId) {
		super();
		this.type = type;
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.securityCode = securityCode;
		this.expiryDate = expiryDate;
		this.subAccountId = subAccountId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", type=" + type + ", cardNumber=" + cardNumber + ", pin=" + pin + ", securityCode="
				+ securityCode + ", expiryDate=" + expiryDate + ", subAccountId=" + subAccountId + ", userId=" + userId
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getSubAccountId() {
		return subAccountId;
	}

	public void setSubAccountId(Date subAccountId) {
		this.subAccountId = subAccountId;
	}

	public Date getUserId() {
		return userId;
	}

	public void setUserId(Date userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
