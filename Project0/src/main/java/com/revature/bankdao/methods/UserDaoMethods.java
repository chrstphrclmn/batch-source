package com.revature.bankdao.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.bankdao.UserDao;
import com.revature.dataaccess.ConnectionDB;
import com.revature.model.entities.User;

public class UserDaoMethods implements UserDao {

//	@Override
//	public List<User> getUsers() {
//		
//		return null;
//	}

	@Override
	public User getUser(int userId) {
		
		String sql = "select * from usuario where userid = ?";
		User u = null;
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, userId); // jdbc 1 based index
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userid= rs.getInt("userid");
				String name= rs.getString("ClientName");
				String userName= rs.getString("username");
				String address= rs.getString("useraddress");
				String email= rs.getString("email");
				String password= rs.getString("pasword");
				u= new User(userid,name,userName,address,email,password);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public int createUser(User u) {                     // CreateUser Completed
		String sql = "select * from adduser(?,?,?,?,?)";
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql) ){
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getAddress());
			ps.setString(5, u.getPasword());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			u.setId(rs.getInt("userid"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}
	
	
	public int deleteUser(int userId) {
		int rowsDeleted = 0;
		String sql = "delete from usuario where userId = ?";
		
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setInt(1, userId);
			rowsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsDeleted;
		
	}

	@Override
	public int confirmUser(String userName, String password) {
		int idUsuario=0;
		String sql = "select* from usuario where username = ? and pasword = ?";
		try(Connection c = ConnectionDB.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				idUsuario = rs.getInt("userId");
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return idUsuario;
	}


}
