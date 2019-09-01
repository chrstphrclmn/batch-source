package com.revature.project.zero.dao;

import java.util.List;

import com.revature.project.zero.model.Session;

public interface SessionDAO {
	
	public List<Session> getSessions();
	public int createSession(Session session);
	public int deleteSession(Session session);

}
