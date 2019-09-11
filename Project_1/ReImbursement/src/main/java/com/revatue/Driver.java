package com.revatue;

import java.util.List;

import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.models.Employee;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDao e = new EmployeeDaoImpl();
		
		List<Employee> employees = e.getEmployees();
		
		for(Employee em : employees) {
			System.out.println(em);
		}
		
		System.out.println(e.getUsernames());

	}

}
