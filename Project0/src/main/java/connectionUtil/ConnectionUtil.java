
package connectionUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection connection;
	private static boolean isConnected;
	
	public static Connection getConnection() throws SQLException {
			if(isConnected == true) {
				return connection;
			} else {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				String url = "jdbc:postgresql://revature-db1.cw9kgs0pw9lf.us-east-2.rds.amazonaws.com:5432/postgres";
				String username = System.getenv("DB_USER");
				String password = System.getenv("DB_PASS");

				if(connection == null || connection.isClosed()) {
					connection = DriverManager.getConnection(url, username, password);
				}

				return getH2Connection();
			}
	}
	
	public static Connection getH2Connection() {
		try {
			if(connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection("jdbc:h2:~/test");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
