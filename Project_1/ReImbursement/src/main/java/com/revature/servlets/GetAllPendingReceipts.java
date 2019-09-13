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
import com.revature.daos.ReceiptDaoImpl;
import com.revature.daos.ReceiptsDao;
import com.revature.models.Receipts;

/**
 * Servlet implementation class GetAllPendingReceipts
 */
//@WebServlet("/GetAllPendingReceipts")
public class GetAllPendingReceipts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllPendingReceipts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ReceiptsDao rd = new ReceiptDaoImpl();
		
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("user_name");
		String password = (String) session.getAttribute("password");
		
		List<Receipts> receipts = rd.getAllPendingReceipts();
		
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
