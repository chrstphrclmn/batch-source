package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daos.ReceiptDaoImpl;
import com.revature.daos.ReceiptsDao;

/**
 * Servlet implementation class ActionApprovePending
 */
@WebServlet("/ActionApprovePending")
public class ActionApprovePending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionApprovePending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hit post request");

		ReceiptsDao rd = new ReceiptDaoImpl();
		
		HttpSession session = request.getSession(false);
		
		String username = (String) session.getAttribute("user_name");
		String password = (String) session.getAttribute("password");
		
//		Integer receipt_id = Integer.parseInt(request.getParameter("receipt_id"));
		int x = 0;
		System.out.println(x + " DEBUG: "+ request.getHeader("receipt_id"));
		x++;
		Integer receipt_id = Integer.parseInt(request.getHeader("receipt_id"));
		x++;
		System.out.println(x + " DEBUG: ");
		
		rd.approveReceipt(receipt_id);
		
		response.sendRedirect("/Reimbursement/allpending");
	}

}
