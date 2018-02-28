import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import beans.CurrentUser;

public class MainApp extends JFrame implements ActionListener {

	JFrame mainPage;
	JLabel emailL, passwordL;
	JTextField emailtf;
	JPasswordField passwordtf;
	JButton regbnt, loginbtn;
	JLabel logo;
	String logopath = "icons/bookmyshow.png";

	public MainApp() {

		mainPage = new JFrame("Book My Show");
		mainPage.getContentPane().setBackground(Color.white);
		mainPage.setBounds(250, 200, 450, 350);
		mainPage.setResizable(false);

		mainPage.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));

		// --

		logo = new JLabel();
		logo.setBounds(20, 5, 400, 114);
		ImageIcon iclogo = new ImageIcon(logopath);
		logo.setIcon(iclogo);
		mainPage.add(logo);

		emailL = new JLabel("Email ");
		emailL.setFont(new Font("Arial", Font.BOLD, 25));
		emailL.setBounds(20, 130, 100, 25);
		mainPage.add(emailL);

		emailtf = new JTextField();
		emailtf.setBounds(170, 130, 230, 25);
		emailtf.setFont(new Font("Arial", Font.BOLD, 15));
		emailtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		mainPage.add(emailtf);

		passwordL = new JLabel("Password ");
		passwordL.setFont(new Font("Arial", Font.BOLD, 25));
		passwordL.setBounds(20, 170, 150, 25);
		mainPage.add(passwordL);

		passwordtf = new JPasswordField();
		passwordtf.setBounds(170, 170, 230, 25);
		passwordtf.setFont(new Font("Arial", Font.BOLD, 15));
		passwordtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		mainPage.add(passwordtf);

		regbnt = new JButton("Register");
		regbnt.setFont(new Font("Arial", Font.BOLD, 19));
		regbnt.setBounds(20, 230, 140, 45);
		regbnt.setBackground(Color.decode("#e74c3c"));
		regbnt.setOpaque(true);
		regbnt.setForeground(Color.WHITE);
		mainPage.add(regbnt);

		regbnt.addActionListener(this);

		loginbtn = new JButton("Login");
		loginbtn.setFont(new Font("Arial", Font.BOLD, 19));
		loginbtn.setBounds(260, 230, 140, 45);
		loginbtn.setBackground(Color.decode("#e74c3c"));
		loginbtn.setOpaque(true);
		loginbtn.setForeground(Color.WHITE);
		mainPage.add(loginbtn);
		loginbtn.addActionListener(this);

		// --
		mainPage.setLayout(null);
		mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPage.setVisible(true);

	}

	public static void main(String[] args) {

		MainApp mapp = new MainApp();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regbnt) {
			RegisterNewUser rg = new RegisterNewUser();
			
		}
		if (e.getSource() == loginbtn) {
			String email = emailtf.getText().toString();
			String password = passwordtf.getText().toString();

			if(checkUserData(email, password)) {
				MovieShowcase mv = new MovieShowcase();
				mainPage.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Invalid credentials");
			}
			
		}

	}

	private boolean checkUserData(String email, String password) {
			try {
				Connection con = ConnectionProvider.getConnection();
				Statement st = con.createStatement();
				
			ResultSet rs = 	st.executeQuery("select * from userinfo where email = '"+email+"' and password = '"+password+"' ");
				if(rs.next()) {
					//JOptionPane.showMessageDialog(this, "Login success");
					emailtf.setText("");
					passwordtf.setText("");
					
					// saving current user data.
					
					String name = rs.getString("name");
					String emailId = rs.getString("email");
					String pass = rs.getString("password");
					String phn = rs.getString("phone");
					
					ServiceProvider.getCurrentUser(name, emailId, pass, phn);
					
					
				}else {
					
					return false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
			
	}

}
