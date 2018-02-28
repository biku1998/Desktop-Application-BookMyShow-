import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterNewUser extends JFrame implements ActionListener {

	JFrame regPage;
	JLabel emailL, passwordL, nameL, cfpasswordL, phoneL, icon;
	JTextField emailtf, nametf, phonetf;
	JPasswordField passwordtf, cfpasswordtf;
	JButton regbnt;
	String logopath = "G:\\BMS(Images)\\appicon2.jpg";

	public RegisterNewUser() {

		regPage = new JFrame("Sign Up");
		regPage.getContentPane().setBackground(Color.white);
		regPage.setBounds(710, 100, 450, 550);
		regPage.setResizable(false);
		regPage.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon.jpg")));
		// --

		icon = new JLabel();
		icon.setBounds(170, 10, 100, 100);
		ImageIcon ic = new ImageIcon(logopath);
		icon.setIcon(ic);
		regPage.add(icon);

		nameL = new JLabel("Name");
		nameL.setBounds(30, 140, 100, 25);
		nameL.setFont(new Font("Arial", Font.BOLD, 25));
		regPage.add(nameL);

		nametf = new JTextField();
		nametf.setBounds(170, 140, 190, 25);
		nametf.setFont(new Font("Arial", Font.BOLD, 15));
		nametf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		regPage.add(nametf);

		emailL = new JLabel("Email");
		emailL.setBounds(30, 200, 100, 25);
		emailL.setFont(new Font("Arial", Font.BOLD, 25));
		regPage.add(emailL);

		emailtf = new JTextField();
		emailtf.setBounds(170, 200, 240, 25);
		emailtf.setFont(new Font("Arial", Font.BOLD, 15));
		emailtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		regPage.add(emailtf);

		passwordL = new JLabel("Password");
		passwordL.setBounds(30, 260, 170, 25);
		passwordL.setFont(new Font("Arial", Font.BOLD, 25));
		regPage.add(passwordL);

		passwordtf = new JPasswordField();
		passwordtf.setBounds(170, 260, 190, 25);
		passwordtf.setFont(new Font("Arial", Font.BOLD, 15));
		passwordtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		regPage.add(passwordtf);

		cfpasswordL = new JLabel("Confirm Password");
		cfpasswordL.setBounds(30, 320, 270, 25);
		cfpasswordL.setFont(new Font("Arial", Font.BOLD, 25));
		regPage.add(cfpasswordL);

		cfpasswordtf = new JPasswordField();
		cfpasswordtf.setBounds(270, 320, 150, 25);
		cfpasswordtf.setFont(new Font("Arial", Font.BOLD, 15));
		cfpasswordtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		regPage.add(cfpasswordtf);

		phoneL = new JLabel("Phone no");
		phoneL.setBounds(30, 380, 150, 25);
		phoneL.setFont(new Font("Arial", Font.BOLD, 25));
		regPage.add(phoneL);

		phonetf = new JTextField();
		phonetf.setBounds(170, 380, 190, 25);
		phonetf.setFont(new Font("Arial", Font.BOLD, 15));
		phonetf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		regPage.add(phonetf);

		regbnt = new JButton("Register");
		regbnt.setFont(new Font("Arial", Font.BOLD, 19));
		regbnt.setBounds(230, 440, 190, 45);
		regbnt.setBackground(Color.decode("#2d3436"));
		regbnt.setOpaque(true);
		regbnt.setForeground(Color.WHITE);
		regPage.add(regbnt);
		regbnt.addActionListener(this);

		// --

		regPage.setLayout(null);
		regPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regPage.setVisible(true);

	}

	public static void main(String[] args) {
		RegisterNewUser r = new RegisterNewUser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regbnt) {
			String name = nametf.getText().toString();
			String email = emailtf.getText().toString();
			String password = passwordtf.getText().toString();
			String pass = cfpasswordtf.getText().toString();
			String phone = phonetf.getText().toString();

			if (name.isEmpty() || email.isEmpty() || password.isEmpty() || pass.isEmpty() || phone.isEmpty()) {
				JOptionPane.showMessageDialog(this, "empty field");
			} else {
				if (password.equalsIgnoreCase(pass)) {
					SaveNewUser.saveData(name, email, password, phone);
					nametf.setText("");emailtf.setText("");passwordtf.setText("");cfpasswordtf.setText("");
					phonetf.setText("");
					JOptionPane.showMessageDialog(this, "Registration Sucess");
					regPage.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(this, "password not matched");
				}

			}

		}

	}
}
