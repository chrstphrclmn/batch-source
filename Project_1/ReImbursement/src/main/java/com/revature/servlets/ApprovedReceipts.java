package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ReceiptDaoImpl;
import com.revature.daos.ReceiptsDao;
import com.revature.models.Receipts;

/**
 * Servlet implementation class ApprovedReceipts
 */
//@WebServlet("/ApprovedReceipts")
public class ApprovedReceipts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedReceipts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeDao e = new EmployeeDaoImpl();
		
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("user_name");
		String password = (String) session.getAttribute("password");
		
		int emp_id = e.login(username, password);
		
		ReceiptsDao rd = new ReceiptDaoImpl();
		
		List<Receipts> receipts = rd.getApprovedReceipts(emp_id);
		
		System.out.println(receipts);
		
		ObjectMapper om = new ObjectMapper();
		String receiptsJSON = om.writeValueAsString(receipts);
		System.out.println(receiptsJSON);
		
		try(PrintWriter pw = response.getWriter()){
			
			pw.write(receiptsJSON);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
