import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CurrentUser;
import beans.Movies;

public class ServiceProvider {

	static ArrayList<CurrentUser> userList = new ArrayList<CurrentUser>();
	static ArrayList<Integer> moviePrice = new ArrayList<Integer>();
	static ArrayList<Integer> snacksPrice = new ArrayList<Integer>();
	static ArrayList<String> movieName = new ArrayList<String>();
	static ArrayList<String> movieTiming = new ArrayList<String>();
	static ArrayList<Movies> getMovies() {

		ArrayList<Movies> movie = new ArrayList<Movies>();

		try {

			Connection con = ConnectionProvider.getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from movies");

			while (rs.next()) {

				String mname = rs.getString("name");
				String mtype = rs.getString("type");
				String mrat = rs.getString("rating");
				String mdesc = rs.getString("description");
				byte[] mimage = rs.getBytes("image");

				Movies m = new Movies();

				m.setMovieName(mname);
				m.setMovieType(mtype);
				m.setMovierating(mrat);
				m.setMovieDesc(mdesc);
				m.setMovieImage(mimage);

				movie.add(m);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movie;

	}

	static void getCurrentUser(String name, String email, String password, String phone) {
		ArrayList<CurrentUser> user = new ArrayList<CurrentUser>();
		CurrentUser c = new CurrentUser();
		c.setName(name);
		c.setEmail(email);
		c.setPassword(password);
		c.setPhone(phone);
		user.add(c);
		userList.addAll(user);
	}
	
	static void getTicketMoney(int moneyTicket) {
		moviePrice.add(moneyTicket);
	}
	
	static void getSnacksTicket(int snackMoney) {
		snacksPrice.add(snackMoney);
	}
	
	static void setMovieName(String movieN) {
		movieName.add(movieN);
	}
	
	static void setMovieTime(String time) {
		movieTiming.add(time);
	}
	
	
	

}
