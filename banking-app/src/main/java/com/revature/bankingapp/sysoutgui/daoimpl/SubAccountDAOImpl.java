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

import com.revature.bankingapp.sysoutgui.dao.SubAccountDAO;
import com.revature.bankingapp.sysoutgui.model.SubAccount;
import com.revature.bankingapp.sysoutgui.security.DatabaseCredentials;

public class SubAccountDAOImpl implements SubAccountDAO{

	@Override
	public Optional<SubAccount> findById(long id) {
		Optional<SubAccount> subaccountOptional = Optional.empty();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM accounts WHERE id=" + id;
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long subaccountId = rs.getLong("id");
				Long accountId = rs.getLong("account_id");
				String type = rs.getString("password");
				Double amount = rs.getDouble("amount");
				SubAccount subaccount = new SubAccount(subaccountId, type, amount, accountId);
				subaccountOptional = Optional.of(subaccount);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subaccountOptional;
	}

	@Override
	public List<SubAccount> findAll() {
		List<SubAccount> subAccounts = new ArrayList<SubAccount>();
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			String query = "SELECT * FROM accounts";
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Long subaccountId = rs.getLong("id");
				Long accountId = rs.getLong("account_id");
				String type = rs.getString("password");
				Double amount = rs.getDouble("amount");
				SubAccount subaccount = new SubAccount(subaccountId, type, amount, accountId);
				subAccounts.add(subaccount);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subAccounts;
	}

	@Override
	public void save(SubAccount subAccount) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO subaccounts values(default,?,?,?)");
			stmt.setString(1, subAccount.getType());
			stmt.setDouble(2, subAccount.getAmount());
			stmt.setLong(3, subAccount.getAccountId());

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(SubAccount subAccount, String[] params) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE subaccounts SET type= ?, amount=?, account_id=? WHERE id=?");
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			stmt.setLong(4, subAccount.getId());
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(SubAccount subAccount) {
		try (Connection conn = DriverManager.getConnection(DatabaseCredentials.getUrl(), DatabaseCredentials.getUser(),
				DatabaseCredentials.getPass());) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_SENSITIVE);
			String del = "DELETE FROM subaccounts WHERE id=" + "'" + subAccount.getId() + "'";
			stmt.executeUpdate(del);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
