package com.revature.bankingapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class FeeHandler {

	private void deductFees(Double fee) {
		String sql = "{call deduct_fees(?)}";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());CallableStatement stmt = conn.prepareCall(sql);) {
			stmt.setDouble(1, fee);
			stmt.execute();
			System.out.println("Fees deducted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void schedule() {
		LocalDate firstDayOfMonth = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
		LocalDate currentDate = LocalDate.now();
		if (currentDate.getDayOfYear() == firstDayOfMonth.getDayOfYear()) {
			deductFees(10d);
		}
	}
}
