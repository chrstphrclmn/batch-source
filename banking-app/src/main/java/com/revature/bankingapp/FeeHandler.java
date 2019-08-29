package com.revature.bankingapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class FeeHandler {

	private void deductFees() {
//		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
//				DatabaseCredentials.getPass());) {
//			CallableStatement stmt=conn.prepareCall("{?= call sum4(?,?)}");  
//			stmt.setInt(2,10);  
//			stmt.setInt(3,43);  
//			stmt.registerOutParameter(1,Types.INTEGER);  
//			stmt.execute();  
//			  
//			System.out.println(stmt.getInt(1)); 
//		}catch (SQLException e){
//			
//		}
	}

	public void schedule() {
		deductFees();
//		LocalDate firstDayOfMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
//		LocalDate currentDate = LocalDate.now();
//		if (currentDate.getDayOfYear() == firstDayOfMonth.getDayOfYear()) {
//			deductFees();
//		}
	}
}
