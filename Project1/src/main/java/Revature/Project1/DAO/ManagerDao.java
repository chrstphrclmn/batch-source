package Revature.Project1.DAO;

import Revature.Project1.Model.Manager;

public interface ManagerDao {
	public boolean createManager(Manager m);
	public int loginManager(String userName, String passWord);
}
