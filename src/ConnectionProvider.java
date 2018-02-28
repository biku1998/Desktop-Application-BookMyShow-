import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/bookmyshow", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
