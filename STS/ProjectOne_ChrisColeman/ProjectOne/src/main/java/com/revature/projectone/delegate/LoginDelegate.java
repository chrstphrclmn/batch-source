package com.revature.projectone.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.model.Login;
import com.revature.projectone.service.impl.LoginServiceImpl;

public class LoginDelegate {
	
	private LoginServiceImpl ls = new LoginServiceImpl();
	
	
	public void getLogins(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Login> logins = ls.logins();
		
		try (PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(logins));
		}
		
		
	}
	
	public void updateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String updateData = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		
		Login p = om.readValue(updateData, Login.class);
		
		Login old = ls.getLoginByUsername(p.getUsername());
		
		old.setFirstName(p.getFirstName());
		old.setLastName(p.getLastName());
		old.setTitle(p.getTitle());
		old.setEmail(p.getEmail());
		old.setPhone(p.getPhone());
		
		ls.updateLogin(old);
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String loginData = request.getReader().readLine();
		
		System.out.println(loginData);
		
		ObjectMapper om = new ObjectMapper();
		
		Login p = om.readValue(loginData, Login.class);
		
		
		System.out.println(p);
		
		if(ls.validLogin(p)) {
			response.setHeader("authorized", p.getUsername()+":"+p.isManager());
			
			if(ls.isAManager(p.getUsername()) && p.isManager()) {
				response.setHeader("manager", "true");
			}
			else {
				response.setHeader("manager", "");
			}
		}
		else {
			response.setHeader("authorized", "");
		}
	/*	
		boolean success = ps.addPizza(p);
		if(success) {
			response.setStatus(201);
		} else {
			response.sendError(400);
		}
		*/
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
