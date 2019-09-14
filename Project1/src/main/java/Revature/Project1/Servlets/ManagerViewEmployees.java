package Revature.Project1.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Revature.Project1.DAO.EmployeeDao;
import Revature.Project1.DAOImpl.EmployeeDaoImpl;
import Revature.Project1.Model.Employee;

public class ManagerViewEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerViewEmployees() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao ed = new EmployeeDaoImpl();
		List<Employee> employees = ed.getEmployee();
		ObjectMapper om = new ObjectMapper();
		String employeeJSON = om.writeValueAsString(employees);
		response.setHeader("employeeJSON", employeeJSON);	
		request.getRequestDispatcher("/Html/ManagerViewEmployees.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
