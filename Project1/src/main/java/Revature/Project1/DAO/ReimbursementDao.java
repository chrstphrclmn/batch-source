package Revature.Project1.DAO;

import java.util.List;
import Revature.Project1.Model.Reimbursement;

public interface ReimbursementDao {
	public boolean createReimbursement(Reimbursement r);
	public boolean approveReimbursement(int id,int id2);
	public boolean denyReimbursement(int id,int id2);
	public List<Reimbursement> employeeGetReimbursement(int id);
	public List<Reimbursement> reimbursementWithEmpName();
	public List<Reimbursement> approvedReimbursementWithEmpName();
	public List<Reimbursement> getEmployeeApprovedReimbursement(int id);
	public List<Reimbursement> getEmployeeDeniedReimbursement(int id);
	public List<Reimbursement> deniedReimbursementWithEmpName();
}
