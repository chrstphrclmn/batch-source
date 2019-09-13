package com.revature.projectone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.projectone.delegate.LoginDelegate;
import com.revature.projectone.delegate.ViewDelegate;

public class RequestHelper {
	
	private ViewDelegate vd = new ViewDelegate();
	private LoginDelegate ld = new LoginDelegate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String uri = request.getServletPath();
		if(uri.startsWith("/api/")) {
			// we want to handle this as if it's requesting (a) record(s)
			String record = uri.substring(5);
			switch(record) {
			
			case "logins":{
				ld.getLogins(request, response);
				break;
			}


			default:
				response.sendError(404, "record not supported");
			}
		} else {
			// we want to handle this as if it's requesting a view
			vd.returnView(request, response);
		}
		
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("Processing the post.");
		String uri = request.getServletPath();
		System.out.println(uri);
		
		switch(uri) {
		
		case "/createlogin":{
			ld.createLogin(request, response);
			break;
		}
		
		default:
			response.sendError(404, "Post not supported.");
		}
	}

}
