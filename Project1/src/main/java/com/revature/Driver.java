package com.revature;

import org.apache.log4j.PropertyConfigurator;

import com.revature.dao.EmployeeDao;
import com.revature.dao.RequestDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.dao.impl.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Request;

public class Driver {

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("C:\\Users\\micha\\Documents\\sts-3.9.7.RELEASE\\plugins\\org.apache.axis_1.4.0.v201411182030\\lib\\log4j.properties");
		
		EmployeeDao edao = new EmployeeDaoImpl();
		RequestDao rdao = new RequestDaoImpl();
		
		//edao.createEmployee(new Employee("mjzhang2", "password123", "Michael", "Zhang", "mjzhang@email.com", 1));
		rdao.createRequest(new Request(1, "mjzhang2", 0, 2, 100.00d));
	}
}
