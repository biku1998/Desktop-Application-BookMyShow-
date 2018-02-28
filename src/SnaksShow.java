import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import beans.CurrentUser;

public class SnaksShow extends JFrame implements ActionListener {

	JFrame showSnack;
	JLabel title, guideL, price1L, price2L, price3L, totalL,qty1,qty2,qty3;
	JButton snack1, snack2, snack3, btnNo, btnNext;
	
	//--data
	int p1 = 200;
	int p2 = 100;
	int p3 = 240;
	
	int q1,q2,q3;
	
	int total;
	
	//

	
	 private void updateAllLabels() {
		 qty1.setText(String.valueOf(q1));
		 qty2.setText(String.valueOf(q2));
		 qty3.setText(String.valueOf(q3));
		 
		
	 }
	public SnaksShow() {
		showSnack = new JFrame("Select Snaks");
		showSnack.setBounds(500, 100, 500, 600);
		showSnack.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));
		showSnack.getContentPane().setBackground(Color.decode("#162029")); 
		showSnack.setResizable(false);
		//--
		
		title = new JLabel("Avaliable Snacks");
		title.setFont(new Font("SansSerif", Font.BOLD, 26));
		title.setForeground(Color.white);
		title.setBounds(140, 20, 240, 25);
		showSnack.add(title);
		
		guideL = new JLabel("Click to add");
		guideL.setFont(new Font("SansSerif", Font.BOLD, 16));
		guideL.setForeground(Color.white);
		guideL.setBounds(190, 70, 240, 25);
		showSnack.add(guideL);
		
		snack1 = new JButton();
		snack1.setBounds(45, 120, 100, 100);
		snack1.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		ImageIcon sn1 =  new ImageIcon("snacksImage/popcorn.jpg");
		snack1.setIcon(sn1);
		
		showSnack.add(snack1);
		
		
		price1L = new JLabel("Rs. "+String.valueOf(p1));
		price1L.setBounds(275, 150, 100, 30);
		price1L.setForeground(Color.white);
		price1L.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(price1L);
		
		qty1 = new JLabel(String.valueOf(q1));
		qty1.setBounds(395, 150, 100, 30);
		qty1.setForeground(Color.white);
		qty1.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(qty1);
		
		qty2 = new JLabel(String.valueOf(q2));
		qty2.setBounds(395, 270, 100, 30);
		qty2.setForeground(Color.white);
		qty2.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(qty2);
		
		qty3 = new JLabel(String.valueOf(q3));
		qty3.setBounds(395, 390, 100, 30);
		qty3.setForeground(Color.white);
		qty3.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(qty3);

		price2L = new JLabel("Rs. "+String.valueOf(p2));
		price2L.setBounds(275, 270, 100, 30);
		price2L.setForeground(Color.white);
		price2L.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(price2L);
		
		
		price3L = new JLabel("Rs. "+String.valueOf(p3));
		price3L.setBounds(275, 390, 100, 30);
		price3L.setForeground(Color.white);
		price3L.setFont(new Font("SansSerif", Font.BOLD, 16));
		showSnack.add(price3L);
		
		

		snack2 = new JButton();
		snack2.setBounds(45, 240, 100, 100);
		snack2.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		ImageIcon sn2 =  new ImageIcon("snacksImage/pepsi.jpg");
		snack2.setIcon(sn2);
		showSnack.add(snack2);
		
		snack3 = new JButton();
		snack3.setBounds(45, 360, 100, 100);
		snack3.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		ImageIcon sn3 =  new ImageIcon("snacksImage/noodles.jpg");
		snack3.setIcon(sn3);
		showSnack.add(snack3);
		
		
		
		btnNo = new JButton("Skip");
		btnNo.setBounds(45, 490, 130, 45);
		btnNo.setForeground(Color.white);
		btnNo.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNo.setBackground(Color.decode("#0a0f13"));
		showSnack.add(btnNo);
		
		btnNext = new JButton("Proceed");
		btnNext.setBounds(275, 490, 130, 45);
		btnNext.setForeground(Color.white);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNext.setBackground(Color.decode("#0a0f13"));
		showSnack.add(btnNext);
		
		btnNext.addActionListener(this);
		btnNo.addActionListener(this);
		snack1.addActionListener(this);
		snack2.addActionListener(this);
		snack3.addActionListener(this);
		
		
		//--
		showSnack.setLayout(null);
		//showSnack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showSnack.setVisible(true);
		
		
	}
/*
	public static void main(String[] args) {
		SnaksShow s = new SnaksShow();
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == btnNext) {
			this.total = (q1*p1)+(q2*p2)+(q3*p3);
			if(total>0) {
				ServiceProvider.getSnacksTicket(total);
				showSnack.setVisible(false);
				PaymentPortal pt = new PaymentPortal();
				
				/*ArrayList<CurrentUser> u = ServiceProvider.userList;
				for (CurrentUser cur : u) {
					System.out.println(cur.getName()+" : "+cur.getEmail()+" : "+cur.getPassword()+" : "+cur.getPhone());
				}*/
				
			}else {
				JOptionPane.showMessageDialog(this,"Empty Snacks Field");
			}
		}
		if(e.getSource()== btnNo) {
			PaymentPortal p = new PaymentPortal();
			ServiceProvider.getSnacksTicket(0);
		}
		if(e.getSource()==snack1) {
			this.q1++;
			updateAllLabels();
		}
		if(e.getSource()==snack2) {
			this.q2++;
			updateAllLabels();
		}
		if(e.getSource()==snack3) {
			this.q3++;
			updateAllLabels();
		}
		
	}
}
