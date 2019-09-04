package com.revature.bankingapp.sysoutgui.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bankingapp.sysoutgui.dao.TransactionHistoryDAO;
import com.revature.bankingapp.sysoutgui.model.TransactionHistory;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	private final String[] databaseColumns = { "id", "history", "subaccount_id" };
	private static Logger logger = LogManager.getLogger();

	@Override
	public Optional<TransactionHistory> findById(long id) {
		Optional<TransactionHistory> tHistoryOptional = Optional.empty();
		String query = "SELECT * FROM transaction_histories WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long tHistoryId = rs.getLong(databaseColumns[0]);
				String history = rs.getString(databaseColumns[1]);
				Long subaccount_id = rs.getLong(databaseColumns[2]);
				TransactionHistory tHistory = new TransactionHistory(tHistoryId, history, subaccount_id);
				tHistoryOptional = Optional.of(tHistory);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return tHistoryOptional;
	}

	@Override
	public Optional<TransactionHistory> findBySubAccountId(long id) {
		Optional<TransactionHistory> tHistoryOptional = Optional.empty();
		String query = "SELECT * FROM transaction_histories WHERE subaccount_id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Long tHistoryId = rs.getLong(databaseColumns[0]);
				String history = rs.getString(databaseColumns[1]);
				Long subaccount_id = rs.getLong(databaseColumns[2]);
				TransactionHistory tHistory = new TransactionHistory(tHistoryId, history, subaccount_id);
				tHistoryOptional = Optional.of(tHistory);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return tHistoryOptional;
	}

	@Override
	public List<TransactionHistory> findAll() {
		List<TransactionHistory> tHistories = new ArrayList<TransactionHistory>();
		String query = "SELECT * FROM transaction_histories";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
				ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next()) {
				Long tHistoryId = rs.getLong(databaseColumns[0]);
				String history = rs.getString(databaseColumns[1]);
				Long subaccount_id = rs.getLong(databaseColumns[2]);
				TransactionHistory tHistory = new TransactionHistory(tHistoryId, history, subaccount_id);
				tHistories.add(tHistory);
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		return tHistories;
	}

	@Override
	public Long save(TransactionHistory transactionHistory) {
		String query = "INSERT INTO transaction_histories values(default,?,?)";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());
				PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
			stmt.setString(1, transactionHistory.getHistory());
			stmt.setLong(2, transactionHistory.getSubaccount_id());

			int i = stmt.executeUpdate();

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					transactionHistory.setId(generatedKeys.getLong("id"));
					logger.info(i + " records inserted");
				} else {
					throw new SQLException("Creating TransactionHistory failed, no ID obtained.");
				}
			}

		} catch (SQLException e) {
			logger.error(e);
		}

		return transactionHistory.getId();
	}

	@Override
	public void update(TransactionHistory transactionHistory) {
		String query = "UPDATE transaction_histories SET history= ?, subaccount_id=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, transactionHistory.getHistory());
			stmt.setLong(2, transactionHistory.getSubaccount_id());
			stmt.setLong(3, transactionHistory.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records updated");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public void delete(TransactionHistory transactionHistory) {
		String query = "DELETE FROM transaction_histories WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass()); PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setLong(1, transactionHistory.getId());
			int i = stmt.executeUpdate();
			logger.info(i + " records deleted");
		} catch (SQLException e) {
			logger.error(e);
		}
	}

}
