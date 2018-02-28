
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SaveNewUser {

	static void saveData(String name, String email, String password, String phone) {

		try {

			Connection conn = ConnectionProvider.getConnection();

			Statement st = conn.createStatement();

			st.execute(
					"insert into userinfo values('" + name + "','" + email + "','" + password + "','" + phone + "')");

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
