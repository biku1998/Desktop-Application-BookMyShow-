import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import beans.CurrentUser;

public class PaymentPortal extends JFrame implements ActionListener {

	JFrame portal;
	JLabel title, cardNoL, cvvL, nameonCardL, expiryL, total;
	JTextArea cardNo, cvv, nameOnCard, expiry;
	JButton pay;

	public PaymentPortal() {

		portal = new JFrame("Payment Portal");
		portal.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));
		portal.getContentPane().setBackground(Color.decode("#162029"));
		portal.setResizable(false);
		portal.setBounds(500, 50, 400, 400);
		// --
		title = new JLabel("Payment Portal");
		title.setFont(new Font("SansSerif", Font.BOLD, 16));
		title.setForeground(Color.white);
		title.setBounds(130, 10, 240, 25);
		portal.add(title);

		cardNoL = new JLabel("Card No");
		cardNoL.setBounds(25, 45, 100, 25);
		cardNoL.setForeground(Color.white);
		cardNoL.setBackground(Color.decode("#0a0f13"));
		portal.add(cardNoL);

		cardNo = new JTextArea();
		cardNo.setBounds(25, 75, 230, 25);
		cardNo.setFont(new Font("SansSerif", Font.BOLD, 16));
		portal.add(cardNo);

		nameonCardL = new JLabel("Name on Card");
		nameonCardL.setBounds(25, 110, 100, 25);
		nameonCardL.setForeground(Color.white);
		nameonCardL.setBackground(Color.decode("#0a0f13"));
		portal.add(nameonCardL);

		nameOnCard = new JTextArea();
		nameOnCard.setBounds(25, 145, 230, 25);
		nameOnCard.setFont(new Font("SansSerif", Font.BOLD, 16));
		portal.add(nameOnCard);

		expiryL = new JLabel("Expiry Date");
		expiryL.setBounds(25, 180, 100, 25);
		expiryL.setForeground(Color.white);
		expiryL.setBackground(Color.decode("#0a0f13"));
		portal.add(expiryL);

		nameOnCard = new JTextArea();
		nameOnCard.setBounds(25, 210, 180, 25);
		nameOnCard.setFont(new Font("SansSerif", Font.BOLD, 16));
		portal.add(nameOnCard);

		cvvL = new JLabel("Cvv");
		cvvL.setBounds(25, 245, 100, 25);
		cvvL.setForeground(Color.white);
		cvvL.setBackground(Color.decode("#0a0f13"));
		portal.add(cvvL);

		cvv = new JTextArea();
		cvv.setBounds(25, 280, 100, 25);
		cvv.setFont(new Font("SansSerif", Font.BOLD, 16));
		portal.add(cvv);

		int t = 0;
		int mp = 0;
		int sp = 0;
		ArrayList<Integer> tfee = ServiceProvider.moviePrice;
		for (Integer in : tfee) {
			mp = in;
		}

		ArrayList<Integer> sfee = ServiceProvider.snacksPrice;
		for (Integer i : sfee) {
			sp = i;
		}

		t = mp + sp;

		total = new JLabel("Total Rs. " + String.valueOf(t));
		total.setBounds(255, 250, 180, 25);
		total.setFont(new Font("SansSerif", Font.BOLD, 16));
		total.setForeground(Color.white);
		portal.add(total);

		pay = new JButton("Pay");
		pay.setBounds(255, 315, 100, 35);
		pay.setFont(new Font("SansSerif", Font.BOLD, 16));
		pay.setBackground(Color.decode("#0a0f13"));
		pay.setForeground(Color.WHITE);
		portal.add(pay);
		pay.addActionListener(this);

		// --
		portal.setLayout(null);
		// portal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		portal.setVisible(true);

	}

	/*
	 * public static void main(String[] args) { PaymentPortal p = new
	 * PaymentPortal(); }
	 */

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == pay) {

			/*if (cardNo.getText().toString().isEmpty() || nameOnCard.getText().toString().isEmpty()
					|| expiry.getText().toString().isEmpty() || cvv.getText().toString().isEmpty()) {

				JOptionPane.showMessageDialog(this, "Empty Fields");
				
			} else {*/

				String userName = "";
				String userEmail = "";
				String userPass = "";
				String userPhone = "";
				String movie = "";
				String movTime = "";
				int movPrice = 0;
				int snacksPrice = 0;
				int totalMoney = 0;

				ArrayList<CurrentUser> userData = ServiceProvider.userList;

				for (CurrentUser cu : userData) {
					userName = cu.getName();
					userEmail = cu.getEmail();
					userPass = cu.getPassword();
					userPhone = cu.getPhone();
				}

				ArrayList<String> movieName = ServiceProvider.movieName;
				for (String string : movieName) {
					movie = string;
				}

				ArrayList<String> movieTime = ServiceProvider.movieTiming;
				for (String s : movieTime) {
					movTime = s;
				}

				ArrayList<Integer> mprice = ServiceProvider.moviePrice;
				for (Integer integer : mprice) {
					movPrice = integer;
				}

				ArrayList<Integer> sprice = ServiceProvider.snacksPrice;
				for (Integer integer : sprice) {
					snacksPrice = integer;
				}

				totalMoney = movPrice + snacksPrice;

				String mailMessage = "Hello Mr/Miss " + userName + " \n your booking has been confirmed for movie" + " "
						+ movie + " \nTiming :: " + movTime + "::\nAmount paid Rs " + totalMoney
						+ " INR \nThankyou for using our service..";

				// -- mail sending
				Mailer.send("bookmyshowcorp", "ashok9234", userEmail, "Ticket Details From BookMyShow", mailMessage);
				JOptionPane.showMessageDialog(this, "Payment Confirmed. check your email");

			//}
		}

	}

}
