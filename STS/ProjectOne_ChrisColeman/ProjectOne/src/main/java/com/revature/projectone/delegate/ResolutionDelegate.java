package com.revature.projectone.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.projectone.model.Request;
import com.revature.projectone.model.RequestJoin;
import com.revature.projectone.model.Resolution;
import com.revature.projectone.service.impl.RequestServiceImpl;
import com.revature.projectone.service.impl.ResolutionServiceImpl;

public class ResolutionDelegate {
	
	private ResolutionServiceImpl rs = new ResolutionServiceImpl();
	private RequestServiceImpl rqs = new RequestServiceImpl();
	
	public void getResolutions(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Resolution> res = rs.getResolutions();
		
		try (PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(res));
		}
	}
	
	public void getCombinedReqsAndReses(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		List<RequestJoin> joins = new ArrayList<>();
		List<Request> requests = rqs.getRequests();
		List<Resolution> res = rs.getResolutions();
		
		for(Request temp: requests) {
			
			RequestJoin tempJoin = new RequestJoin();
			tempJoin.setRequest(temp);
			
			for(Resolution tempRes: res) {
				if(tempRes.getRequestId()==temp.getRequestId()) {
					tempJoin.setResolution(tempRes);
				}
			}
			
			joins.add(tempJoin);
		}
		
		try (PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(joins));
		}
	}
	
	
	public void createResolution(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		
		String resData = request.getReader().readLine();
		
		ObjectMapper om = new ObjectMapper();
		
		Resolution newRes = om.readValue(resData, Resolution.class);
		
		rs.createResolution(newRes);
	}
	
	

}
