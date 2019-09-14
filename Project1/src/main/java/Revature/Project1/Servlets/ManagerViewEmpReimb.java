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

public class ManagerViewEmpReimb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerViewEmpReimb() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		
		List<Reimbursement> reimbursements = rd.reimbursementWithEmpName();
		ObjectMapper om = new ObjectMapper();
		String reimbursementJSON = om.writeValueAsString(reimbursements);
		response.setHeader("reimbursementJSON", reimbursementJSON);	
		request.getRequestDispatcher("/Html/ManagerViewReimb.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		String id = request.getParameter("id");
		int reid = Integer.parseInt(id);
		
		HttpSession session = request.getSession(false);
		int id2 = (int)session.getAttribute("id");
		
		if(request.getParameter("approve")!=null) {
			System.out.println(5);
			rd.approveReimbursement(reid,id2);
		} else if(request.getParameter("deny")!=null) {
			System.out.println(6);
			rd.denyReimbursement(reid, id2);
		}
		doGet(request,response);
	}

}
