package com.revature.bankingapp.sysoutgui.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class FeeHandler {

	private static Logger logger = ApplicationLogger.getLogger();
	
	private void deductFees(Double fee) {
		String sql = "{call deduct_fees(?)}";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());CallableStatement stmt = conn.prepareCall(sql);) {
			stmt.setDouble(1, fee);
			stmt.execute();
			logger.info("Fees deducted");
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