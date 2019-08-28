package com.revature.bankingapp.sysoutgui.dao;

import java.util.List;
import java.util.Optional;

import com.revature.bankingapp.sysoutgui.model.Card;

public interface CardDAO{

	Optional<Card> findById(long id);

	List<Card> findAll();

	void save(Card card);

	void update(Card card, String[] params);

	void delete(Card card);
}
