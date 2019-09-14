package Revature.Project1.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Revature.Project1.DAO.EmployeeDao;
import Revature.Project1.Model.Employee;
import Revature.Project1.Util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployee() {
		String sql = "Select * from project1.employee";
		List<Employee> emps = new ArrayList<>();
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				Employee e = new Employee();
				e.setName(rs.getString("employee_name"));
				e.setUserName(rs.getString("user_name"));
				e.setPassWord(rs.getString("user_pass"));
				emps.add(e);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
	
	public boolean createEmployee(Employee e) {
		int employeeCreated = 0;
		boolean result = false;
		String sql = "insert into project1.employee (employee_name,user_name,user_pass) values(?,?,?)";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setString(1, e.getName());
				ps.setString(2, e.getUserName());
				ps.setString(3, e.getPassWord());
				employeeCreated = ps.executeUpdate();
			} catch(SQLException er) {
				er.printStackTrace();
			}
		if(employeeCreated!=0) {
			result = true;
		}
		return result;
	}

	@Override
	public int loginEmployee(String userName, String passWord) {
		String sql = "select employee_id from project1.employee where user_name = ? and user_pass = ?";
		String userId;
		int id = 0;
		ResultSet rs;
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
				ps.setString(1, userName);
				ps.setString(2, passWord);
				rs = ps.executeQuery();
				while(rs.next()) {
					userId = rs.getString(1);
					id = Integer.parseInt(userId);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		return id;
	}
	
	public List<Employee> getEmployee(int id) {
		String sql = "Select * from project1.employee where employee_id = ? ";
		List<Employee> emps = new ArrayList<>();
	
		try(Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("employee_name"));
				emp.setUserName(rs.getString("user_name"));
				emp.setPassWord(rs.getString("user_pass"));
				emps.add(emp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return emps;
				
	}

	@Override
	public boolean changeEmployeeUname(String name, int id) {
		boolean response = false;
		String sql = "update project1.employee set user_name = ? where employee_id = ?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setString(1, name);
				ps.setInt(2, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return response;
	}

	@Override
	public boolean changeEmployeePass(String pass, int id) {
		boolean response = false;
		String sql = "update project1.employee set user_pass = ? where employee_id = ?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setString(1, pass);
				ps.setInt(2, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return response;
	}

	@Override
	public boolean changeEmployeeCredentials(String name, String pass, int id) {
		boolean response = false;
		String sql = "update project1.employee set user_name = ?,user_pass = ? where employee_id = ?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setString(1,name);
				ps.setString(2, pass);
				ps.setInt(3, id);
				response = ps.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return response;
	}

}
