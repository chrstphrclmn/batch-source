package com.revature.model.funcionamiento;


import java.util.List;

import com.revature.bankdao.UserDao;
import com.revature.bankdao.methods.UserDaoMethods;
import com.revature.model.entities.User;



public class FuncionamientoUsuarioDao {
	
	private UserDao ed = new UserDaoMethods();
	
	public User getEmployeeById(int id) {
		return ed.getUser(id);
	}
	
	public boolean createEmployee(User e) {
		int employeesCreated = ed.createUser(e);
		if(employeesCreated!=0) {
			return true;
		}
		return false;
	}

}
