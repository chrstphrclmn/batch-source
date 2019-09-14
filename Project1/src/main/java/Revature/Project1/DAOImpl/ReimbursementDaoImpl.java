package Revature.Project1.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Revature.Project1.DAO.ReimbursementDao;
import Revature.Project1.Model.Reimbursement;
import Revature.Project1.Util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public boolean createReimbursement(Reimbursement r) {
		int reimbursementCreated = 0;
		boolean result = false;
		String sql = "insert into project1.reimbursement (reimbursement_amount,description,employee_id) values(?,?,?)";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setDouble(1, r.getAmount());
				ps.setString(2, r.getDescription());
				ps.setInt(3, r.getUserId());
				reimbursementCreated = ps.executeUpdate();
			} catch(SQLException er) {
				er.printStackTrace();
			}
		if(reimbursementCreated!=0) {
			result = true;
		}
		
		
		return result;
	}

	@Override
	public List<Reimbursement> employeeGetReimbursement(int id) {
		String sql = "Select * from project1.reimbursement where employee_id = ? and reimbursement_status isnull";
		List<Reimbursement> embs = new ArrayList<>();
	
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimbursement_id"));
				r.setUserId(rs.getInt("employee_id"));
				r.setAmount(rs.getDouble("reimbursement_amount"));
				r.setDescription(rs.getString("description"));
				embs.add(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return embs;
	}

	@Override
	public List<Reimbursement> reimbursementWithEmpName() {
		String sql = "select project1.employee.employee_name, \r\n" + 
				"project1.reimbursement.reimbursement_id,\r\n" + 
				"project1.reimbursement.reimbursement_amount,\r\n" + 
				"project1.reimbursement.description,\r\n" + 
				"project1.reimbursement.employee_id\r\n" + 
				"from project1.reimbursement\r\n" + 
				"inner join project1.employee on project1.employee.employee_id = project1.reimbursement.employee_id\r\n" + 
				"where project1.reimbursement.reimbursement_status isnull;";
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimbursement_id"));
				r.setEmpName(rs.getString("employee_name"));
				r.setUserId(rs.getInt("employee_id"));
				r.setAmount(rs.getDouble("reimbursement_amount"));
				r.setDescription(rs.getString("description"));
				reimbursements.add(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public boolean approveReimbursement(int id,int id2) {
		boolean response = false;
		String sql = "update project1.reimbursement\r\n" + 
				"set reimbursement_status = 'approved'\r\n" + 
				"where reimbursement_id =?;";
		String sql2 = "update project1.reimbursement\r\n" + 
				"set manager_id = ? where reimbursement_id=?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setInt(1, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)){
				ps.setInt(1, id2);
				ps.setInt(2, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		return response;		
	}

	@Override
	public boolean denyReimbursement(int id,int id2) {
		boolean response = false;
		String sql = "update project1.reimbursement\r\n" + 
				"set reimbursement_status = 'denied'\r\n" + 
				"where reimbursement_id =?;";
		String sql2 = "update project1.reimbursement\r\n" + 
				"set manager_id = ? where reimbursement_id=?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setInt(1, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)){
				ps.setInt(1, id2);
				ps.setInt(2, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		return response;
	}

	@Override
	public List<Reimbursement> deniedReimbursementWithEmpName() {
		String sql = "select project1.employee.employee_name, \r\n" + 
				"project1.reimbursement.reimbursement_id,\r\n" + 
				"project1.reimbursement.reimbursement_amount,\r\n" + 
				"project1.reimbursement.description,\r\n" + 
				"project1.reimbursement.employee_id,\r\n" + 
				"project1.manager.manager_name\r\n" + 
				"from project1.reimbursement\r\n" + 
				"inner join project1.employee on project1.employee.employee_id = project1.reimbursement.employee_id\r\n" + 
				"inner join project1.manager on project1.reimbursement.manager_id = project1.manager.manager_id\r\n" + 
				"where project1.reimbursement.reimbursement_status = 'denied';";
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimbursement_id"));
				r.setEmpName(rs.getString("employee_name"));
				r.setUserId(rs.getInt("employee_id"));
				r.setAmount(rs.getDouble("reimbursement_amount"));
				r.setDescription(rs.getString("description"));
				r.setManagedBy(rs.getString("manager_name"));
				reimbursements.add(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getEmployeeApprovedReimbursement(int id) {
	String sql = "Select * from project1.reimbursement where employee_id = ? and reimbursement_status = 'approved'";
	List<Reimbursement> embs = new ArrayList<>();
	
	try(Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Reimbursement r = new Reimbursement();
			r.setReimbId(rs.getInt("reimbursement_id"));
			r.setUserId(rs.getInt("employee_id"));
			r.setAmount(rs.getDouble("reimbursement_amount"));
			r.setDescription(rs.getString("description"));
			embs.add(r);
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return embs;
	}

	@Override
	public List<Reimbursement> approvedReimbursementWithEmpName() {
		String sql = "select project1.employee.employee_name, \r\n" + 
				"project1.reimbursement.reimbursement_id,\r\n" + 
				"project1.reimbursement.reimbursement_amount,\r\n" + 
				"project1.reimbursement.description,\r\n" + 
				"project1.reimbursement.employee_id,\r\n" + 
				"project1.manager.manager_name\r\n" + 
				"from project1.reimbursement\r\n" + 
				"inner join project1.employee on project1.employee.employee_id = project1.reimbursement.employee_id\r\n" + 
				"inner join project1.manager on project1.reimbursement.manager_id = project1.manager.manager_id\r\n" + 
				"where project1.reimbursement.reimbursement_status = 'approved';";
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimbursement_id"));
				r.setEmpName(rs.getString("employee_name"));
				r.setUserId(rs.getInt("employee_id"));
				r.setAmount(rs.getDouble("reimbursement_amount"));
				r.setDescription(rs.getString("description"));
				r.setManagedBy(rs.getString("manager_name"));
				reimbursements.add(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getEmployeeDeniedReimbursement(int id) {
		String sql = "Select * from project1.reimbursement where employee_id = ? and reimbursement_status = 'denied'";
		List<Reimbursement> embs = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimbursement_id"));
				r.setUserId(rs.getInt("employee_id"));
				r.setAmount(rs.getDouble("reimbursement_amount"));
				r.setDescription(rs.getString("description"));
				embs.add(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return embs;
	}

}
