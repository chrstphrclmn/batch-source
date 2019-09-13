package com.revature.projectone.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.model.Login;
import com.revature.projectone.service.LoginService;
import com.revature.projectone.service.impl.LoginServiceImpl;

public class LoginDelegate {
	
	private LoginService ls = new LoginServiceImpl();
	
	
	public void getLogins(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Login> logins = ls.logins();
		
		try (PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(logins));
		}
		
		
	}
	
	public void createLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		System.out.println("creating a login");
		
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		boolean manager = Boolean.parseBoolean(request.getHeader("manager"));
		
		int returnValue = 0;
		
		if(username != null && ls.isAvailableUsername(username) && password != null){
			
			String firstName = request.getHeader("first_name");
			String lastName = request.getHeader("last_name");
			String title = request.getHeader("title");
			String email = request.getHeader("email");
			String phone = request.getHeader("phone");
			
			returnValue = ls.createLogin(new Login(username, password, manager, firstName, lastName, title, email, phone));
			
			if(returnValue == 1) {
				response.setHeader("result", "good");
			}
			else {
				response.setHeader("result", "bad");
			}
		
		}
	}

}
