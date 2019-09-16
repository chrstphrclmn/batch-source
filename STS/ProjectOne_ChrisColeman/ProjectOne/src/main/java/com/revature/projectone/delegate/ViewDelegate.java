package com.revature.projectone.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {
	
	public void returnView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uri = request.getServletPath();
		switch (uri) {
		case "/login":
			request.getRequestDispatcher("/static/Views/login.html").forward(request, response);
			break;
		case "/employee":
			request.getRequestDispatcher("/static/Views/employeeHome.html").forward(request, response);
			break;
		case "/manager":
			request.getRequestDispatcher("/static/Views/managerHome.html").forward(request, response);
			break;
		default:
			response.sendError(404, "Static Resource Not Found");
		}
	}

}
