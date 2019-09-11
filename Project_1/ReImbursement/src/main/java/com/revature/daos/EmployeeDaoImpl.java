package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		String sql = "select * from employees";
		
		List<Employee> employees = new ArrayList<Employee>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				Integer emp_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				Integer reports_to = rs.getInt("reports_to");
				
				Employee em = new Employee(emp_id, first_name, last_name, reports_to);
				
				employees.add(em);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		Employee em = null;
		
		String sql = "Select * from employees where employee_id = ?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, id); // First question mark gets the id argument
			ResultSet rs = ps.executeQuery();
			
			// loop through results
			while(rs.next()) {
				Integer employee_id = rs.getInt("user_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				Integer reports_to = rs.getInt("reports_to");

				em = new Employee(employee_id, first_name, last_name, reports_to);
			}
			
			// close the statement connection
			rs.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}

	@Override
	public int updateEmployee(Employee old, Employee updated) {
		// TODO Auto-generated method stub
		
		
		return 0;
	}

	@Override
	public List<String> getUsernames() {
		// TODO Auto-generated method stub
		
		String sql = "Select user_name from employees";
		
		List<String> users = new ArrayList<String>();
		
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			
			while(rs.next()) {
				String userName = rs.getString("user_name");
				users.add(userName);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		
		return users;
	}

//	@Override
//	public int createEmployee(Employee e) {
//		// TODO Auto-generated method stub
//		
//		int emplsCreated = 0;
//		
//		
//		return 0;
//	}
	
	
}
