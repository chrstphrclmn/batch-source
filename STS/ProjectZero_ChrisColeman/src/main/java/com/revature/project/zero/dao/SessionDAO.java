package com.revature.project.zero.dao;

import java.util.List;

import com.revature.project.zero.model.Session;

public interface SessionDAO {
	
	public List<Session> getSessions();
	public Session getSessionByKey(String username, int accountNum);
	public void createSession(Session session);
	public void updateSession(Session session);
	public void deleteSession(Session session);

}
