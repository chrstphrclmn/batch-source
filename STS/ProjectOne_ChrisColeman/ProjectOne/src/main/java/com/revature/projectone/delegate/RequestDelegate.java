package com.revature.projectone.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.model.Request;
import com.revature.projectone.service.impl.RequestServiceImpl;

public class RequestDelegate {
	
	private RequestServiceImpl rs = new RequestServiceImpl();
	
	public void getRequests(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Request> reqs = rs.getRequests();
		
		try (PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(reqs));
		}
	}
	
	public void createRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String requestData = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		
		
		Request newReq = om.readValue(requestData, Request.class);
		
		newReq.setRequestId(rs.nextRequestId());
		
		int hold = rs.createRequest(newReq);
		
		System.out.println(hold);
	}

}
