package com.revature.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.User;

import connectionUtil.ConnectionUtil;

public class UserDaoImpl implements UserDAO {
	public List<User> getUser() {
		String sql = "select * from users";
		List<User> users = new ArrayList<>();
		try(Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);){
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("user_id"));
				u.setUserName(rs.getString("user_name"));
				u.setUserPass(rs.getString("user_pass"));
				users.add(u);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public int createUser(User u) {
		int usersCreated = 0;
		String sql = "insert into users (user_name,user_pass) values(?,?)";
		try(Connection c = ConnectionUtil.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getUserPass());
			usersCreated = ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return usersCreated;
	}


	@Override
	public int deleteUser(String user, String pass) {
		UserDAO udao = new UserDaoImpl();
		int id = udao.loginUser(user, pass);
		int usersDeleted = 0;
		String sql = "delete from users where user_id = ?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
				ps.setInt(1, id);
				usersDeleted = ps.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return usersDeleted;
	}

	@Override
	public int loginUser(String userName, String userPass) {
		String userId;
		int id = 0;
		ResultSet rs;
		String sql = "select user_id from users where user_name = ? and user_pass = ?";
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql);){
				ps.setString(1, userName);
				ps.setString(2, userPass);
				rs = ps.executeQuery();
				while(rs.next()) {
					userId = rs.getString(1);
					id = Integer.parseInt(userId);
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return id;
	}

}
