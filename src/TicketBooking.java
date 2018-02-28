import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TicketBooking extends JFrame  implements ActionListener{

	JFrame ticketBook;
	JLabel title,totalL,pavlL, gavlL, genavlL, typeL, goldL, platinumL,
	generalL,tobebookedL,noteL, perpL, pergL, pergenL, bookedPL,bookdedGL,bookedGenL;
	JButton next , pplus,pminus,gplus,gminus,geplus,geminus;

	//-- ticket data
	
	 int PLATINUM_AVL =10;
	 int GOLD_AVL = 20;
	 int GENERAL_AVL = 30;
	 int pbook = 0;
	 int gbook = 0;
	 int gebook = 0;
	
	//--
	 
	 
	 //--method to update the labels.
	 
	 private void updateAllLabels() {
		 pavlL.setText(String.valueOf(PLATINUM_AVL));
		 gavlL.setText(String.valueOf(GOLD_AVL));
		 genavlL.setText(String.valueOf(GENERAL_AVL));
		 
		 bookedPL.setText(String.valueOf(pbook));
		 bookdedGL.setText(String.valueOf(gbook));
		 bookedGenL.setText(String.valueOf(gebook));
	 }
	public TicketBooking() {

		ticketBook = new JFrame("Choose Ticket");
		ticketBook.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));
		ticketBook.getContentPane().setBackground(Color.decode("#22313F"));
		ticketBook.setBounds(500, 50, 500, 400);
		ticketBook.setResizable(false);
		//--
		
		title = new JLabel("Select Tickets");
		title.setFont(new Font("SansSerif", Font.BOLD, 16));
		title.setForeground(Color.white);
		title.setBounds(190, 0, 180, 25);
		ticketBook.add(title);
		
		totalL = new JLabel("Total Avaliable");
		totalL.setBounds(25, 50, 150, 25);
		totalL.setFont(new Font("SansSerif", Font.BOLD, 16));
		totalL.setForeground(Color.white);
		ticketBook.add(totalL);
		
		pavlL = new JLabel(String.valueOf(PLATINUM_AVL));
		pavlL.setBounds(65, 100, 150, 25);
		pavlL.setFont(new Font("SansSerif", Font.BOLD, 16));
		pavlL.setForeground(Color.white);
		ticketBook.add(pavlL);
		
		gavlL = new JLabel(String.valueOf(GOLD_AVL));
		gavlL.setBounds(65, 140, 150, 25);
		gavlL.setFont(new Font("SansSerif", Font.BOLD, 16));
		gavlL.setForeground(Color.white);
		ticketBook.add(gavlL);

		genavlL = new JLabel(String.valueOf(GENERAL_AVL));
		genavlL.setBounds(65, 180, 150, 25);
		genavlL.setFont(new Font("SansSerif", Font.BOLD, 16));
		genavlL.setForeground(Color.white);
		ticketBook.add(genavlL);
		
		
		typeL = new JLabel("Type");
		typeL.setBounds(185, 50, 150, 25);
		typeL.setFont(new Font("SansSerif", Font.BOLD, 16));
		typeL.setForeground(Color.white);
		ticketBook.add(typeL);
		
		platinumL = new JLabel("Platinum");
		platinumL.setBounds(190, 100, 150, 25);
		platinumL.setFont(new Font("SansSerif", Font.BOLD, 16));
		platinumL.setForeground(Color.white);
		ticketBook.add(platinumL);
		
		goldL = new JLabel("Gold");
		goldL.setBounds(190, 140, 150, 25);
		goldL.setFont(new Font("SansSerif", Font.BOLD, 16));
		goldL.setForeground(Color.white);
		ticketBook.add(goldL);

		generalL = new JLabel("General");
		generalL.setBounds(190, 180, 150, 25);
		generalL.setFont(new Font("SansSerif", Font.BOLD, 16));
		generalL.setForeground(Color.white);
		ticketBook.add(generalL);
		
		tobebookedL = new JLabel("To be Booked");
		tobebookedL.setBounds(320, 50, 150, 25);
		tobebookedL.setFont(new Font("SansSerif", Font.BOLD, 16));
		tobebookedL.setForeground(Color.white);
		ticketBook.add(tobebookedL);
		
		
		noteL = new JLabel("Booking Instruction :");
		noteL.setFont(new Font("SansSerif", Font.BOLD, 16));
		noteL.setForeground(Color.white);
		noteL.setBounds(25, 230, 180, 25);
		ticketBook.add(noteL);
		
		perpL = new JLabel("* 5 platinum seats per user(RS.1500 INR)");
		perpL.setFont(new Font("SansSerif", Font.BOLD, 16));
		perpL.setForeground(Color.white);
		perpL.setBounds(25, 260, 320, 25);
		ticketBook.add(perpL);
		
		pergL = new JLabel("* 10 gold seats per user(RS.1000 INR)");
		pergL.setFont(new Font("SansSerif", Font.BOLD, 16));
		pergL.setForeground(Color.white);
		pergL.setBounds(25, 300, 290, 25);
		ticketBook.add(pergL);

		pergenL = new JLabel("* 20 general seats per user(RS.500 INR)");
		pergenL.setFont(new Font("SansSerif", Font.BOLD, 16));
		pergenL.setForeground(Color.white);
		pergenL.setBounds(25, 340, 300, 25);
		ticketBook.add(pergenL);
		
		bookedPL = new JLabel(String.valueOf(pbook));
		bookedPL.setBounds(370, 100, 50, 25);
		bookedPL.setFont(new Font("SansSerif", Font.BOLD, 16));
		bookedPL.setForeground(Color.white);
		ticketBook.add(bookedPL);
		
		
		pplus = new JButton("+");
		pplus.setBounds(400, 100, 40, 25);
		pplus.setFont(new Font("SansSerif", Font.BOLD, 10));
		pplus.setForeground(Color.white);
		pplus.setBackground(Color.BLACK);
		ticketBook.add(pplus);
		
		pminus = new JButton("--");
		pminus.setBounds(444, 100, 40, 25);
		pminus.setFont(new Font("SansSerif", Font.BOLD, 10));
		pminus.setForeground(Color.white);
		pminus.setBackground(Color.BLACK);
		ticketBook.add(pminus);
		
		
		
		
		bookdedGL = new JLabel(String.valueOf(gbook));
		bookdedGL.setBounds(370, 140, 150, 25);
		bookdedGL.setFont(new Font("SansSerif", Font.BOLD, 16));
		bookdedGL.setForeground(Color.white);
		ticketBook.add(bookdedGL);
		
		gplus = new JButton("+");
		gplus.setBounds(400, 140, 40, 25);
		gplus.setFont(new Font("SansSerif", Font.BOLD, 10));
		gplus.setForeground(Color.white);
		gplus.setBackground(Color.BLACK);
		ticketBook.add(gplus);
		
		gminus = new JButton("--");
		gminus.setBounds(444, 140, 40, 25);
		gminus.setFont(new Font("SansSerif", Font.BOLD, 10));
		gminus.setForeground(Color.white);
		gminus.setBackground(Color.BLACK);
		ticketBook.add(gminus);
		
		
		bookedGenL = new JLabel(String.valueOf(gebook));
		bookedGenL.setBounds(370, 180, 150, 25);
		bookedGenL.setFont(new Font("SansSerif", Font.BOLD, 16));
		bookedGenL.setForeground(Color.white);
		ticketBook.add(bookedGenL);
		
		geplus = new JButton("+");
		geplus.setBounds(400, 180, 40, 25);
		geplus.setFont(new Font("SansSerif", Font.BOLD, 10));
		geplus.setForeground(Color.white);
		geplus.setBackground(Color.BLACK);
		ticketBook.add(geplus);
		
		geminus = new JButton("--");
		geminus.setBounds(444, 180, 40, 25);
		geminus.setFont(new Font("SansSerif", Font.BOLD, 10));
		geminus.setForeground(Color.white);
		geminus.setBackground(Color.BLACK);
		ticketBook.add(geminus);
		
		
		
		next = new JButton("Proceed");
		next.setFont(new Font("SansSerif", Font.BOLD, 16));
		next.setForeground(Color.white);
		next.setBackground(Color.BLACK);
		next.setBounds(330, 310, 150, 35);
		ticketBook.add(next);
		
		
		pplus.addActionListener(this);
		pminus.addActionListener(this);
		gplus.addActionListener(this);
		gminus.addActionListener(this);
		geplus.addActionListener(this);
		geminus.addActionListener(this);
		next.addActionListener(this);
		
		
		//--
		ticketBook.setLayout(null);
		//ticketBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ticketBook.setVisible(true);
		
		
	}
	
	
	/*public static void main(String[] args) {
		TicketBooking t = new TicketBooking();
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pplus) {
			
			if(pbook <5) {
				PLATINUM_AVL--;
				pbook++;}
			else {
				JOptionPane.showMessageDialog(this, "Seat limit over");
			}
			updateAllLabels();
			
		}
		if(e.getSource() ==pminus) {
			if(pbook>0) {
				PLATINUM_AVL++;
				pbook--;}
			else {
				JOptionPane.showMessageDialog(this, "no seat selected");
			}
			updateAllLabels();
			
		}
		if(e.getSource()==gplus) {
			
			if(gbook <10) {
				GOLD_AVL--;
				gbook++;}
			else {
				JOptionPane.showMessageDialog(this, "Seat limit over");
			}
			updateAllLabels();
			
		}
		if(e.getSource()==gminus) {
			if(gbook>0) {
				GOLD_AVL++;
				gbook--;}
			else {
				JOptionPane.showMessageDialog(this, "no seat selected");
			}
			updateAllLabels();
		}
		if(e.getSource() ==geplus) {

			if(gebook <20) {
				GENERAL_AVL--;
				gebook++;}
			else {
				JOptionPane.showMessageDialog(this, "Seat limit over");
			}
			updateAllLabels();
		}
		if(e.getSource() == geminus) {
			if(gebook>0) {
				GENERAL_AVL++;
				gebook--;}
			else {
				JOptionPane.showMessageDialog(this, "no seat selected");
			}
			updateAllLabels();
		}
		if(e.getSource()==next) {
			
			int ticketTotal = (this.pbook*1500) + (this.gbook*1000) + (this.gebook*500);
			if(ticketTotal>0) {
			ServiceProvider.getTicketMoney(ticketTotal);
			
			SnaksShow s = new SnaksShow();
			
			ticketBook.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Please book ticket");
			}
			
			
			
			
		}
		
	}

}
