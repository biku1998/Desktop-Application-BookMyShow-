import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddMoviesToDB {

	public static void main(String[] args) {

		String mname = "";
		String mtype = "";
		String mrate = "";
		String mdesc = "";
		try {

			File folderImage = new File("movies");
			File folderDetails = new File("movieDetails");

			File[] filesImage = folderImage.listFiles();

			File[] filesDetails = folderDetails.listFiles();

			/*
			 * for (int i = 0; i < filesImage.length; i++) { System.out.println(filesImage
			 * [i]); }
			 * 
			 * 
			 * for (int i = 0; i < filesDetails.length; i++) {
			 * System.out.println(filesDetails[i]); }
			 */

			for (int i = 0; i < filesDetails.length; i++) {

				FileInputStream fisMDetails = new FileInputStream(filesDetails[i]);
				FileInputStream fisMImage = new FileInputStream(filesImage[i]);

				Scanner sc = new Scanner(fisMDetails);

				while (sc.hasNext()) {
					mname = sc.nextLine();
					mtype = sc.nextLine();
					mrate = sc.nextLine();
					mdesc = sc.nextLine();

				}
				
				Connection con = ConnectionProvider.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into movies values (?,?,?,?,?)");
				ps.setString(1, mname);
				ps.setString(2, mtype);
				ps.setString(3, mrate);
				ps.setString(4, mdesc);
				ps.setBinaryStream(5, (InputStream)fisMImage,(int)filesImage[i].length());
				ps.executeUpdate();
				System.out.println("Movies inserted");
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
