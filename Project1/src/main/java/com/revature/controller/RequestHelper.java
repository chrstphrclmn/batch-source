package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.deligates.LandingDeligate;
import com.revature.deligates.LoginDeligate;
import com.revature.deligates.ViewDeligate;

public class RequestHelper {
	
	private static ViewDeligate viewDeligate = new ViewDeligate();

	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		
		if(uri.startsWith("/api/")) {
			
			String record = uri.substring(5);
			
			if(record.contentEquals("login")) {
				
				new LoginDeligate().login(request, response);
			}
			
			else if(record.startsWith("landing/")) {
				
				String command = record.substring(8);
				
				if (command.contentEquals("requests")) new LandingDeligate().getRequests(request, response);
			}
			
			else {
				
				response.setStatus(400);
			}
		}
		
		else {
			
			viewDeligate.returnView(request, response);
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		
		if(uri.startsWith("/api/")) {
			
			String record = uri.substring(5);
			
			if(record.startsWith("landing/")){
				
				String command = record.substring(8);
				
				if(command.contentEquals("changePassword")) new LandingDeligate().postNewPassword(request, response);
				else if(command.contentEquals("updateRequest")) new LandingDeligate().postUpdateRequest(request, response);	
			}
			
			else {
				
				response.setStatus(400);
			}
		}
		
		else {
			
			response.setStatus(400);
		}
	}
}
