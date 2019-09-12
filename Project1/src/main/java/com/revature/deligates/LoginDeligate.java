package com.revature.deligates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class LoginDeligate {

	private EmployeeService eservice = new EmployeeService();
	private ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		
		Employee user = eservice.logInEmployee(username, password);
		
		if(user == null) {
			
			response.setHeader("Login", "failed");
			return;
		}
		
		response.setHeader("Login", "Success");
		response.setHeader("User", om.writeValueAsString(user));
		response.setHeader("URL", "landing");
		
	}
}
