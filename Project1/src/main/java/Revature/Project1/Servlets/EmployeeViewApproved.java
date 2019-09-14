package Revature.Project1.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Revature.Project1.DAO.ReimbursementDao;
import Revature.Project1.DAOImpl.ReimbursementDaoImpl;
import Revature.Project1.Model.Reimbursement;

public class EmployeeViewApproved extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeViewApproved() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id =(int)session.getAttribute("id");
		//////////
		ReimbursementDao rd = new ReimbursementDaoImpl();
		List<Reimbursement> reimbursements = rd.getEmployeeApprovedReimbursement(id);
		
		ObjectMapper om = new ObjectMapper();
		String reimbursementJSON = om.writeValueAsString(reimbursements);
		response.setHeader("approvedreimbursementJSON", reimbursementJSON);	
		request.getRequestDispatcher("/Html/EmployeeApprovedReimb.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
