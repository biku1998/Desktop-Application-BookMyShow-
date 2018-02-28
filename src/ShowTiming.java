import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import beans.Movies;

public class ShowTiming extends JFrame implements ActionListener {
	JFrame showTime;
	JLabel title;
	JButton moviePic, time1, time2, time3;
	String timeSelected;

	void displayTime(String movie) {

		ServiceProvider.setMovieName(movie);
		
		showTime = new JFrame("Avaliable Show Time");
		showTime.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));
		showTime.getContentPane().setBackground(Color.decode("#22313F"));
		showTime.setBounds(600, 100, 500, 400);
		showTime.setResizable(false);
		// --

		title = new JLabel("Select Show Time");
		title.setFont(new Font("SansSerif", Font.BOLD, 16));
		title.setForeground(Color.white);
		title.setBounds(170, 06, 180, 25);
		showTime.add(title);

		moviePic = new JButton();
		moviePic.setBounds(165, 40, 150, 200);
		moviePic.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		showTime.add(moviePic);

		time1 = new JButton("10(AM) - 1(PM)");
		time1.setFont(new Font("SansSerif", Font.BOLD, 15));
		time1.setBounds(5, 280, 150, 25);
		time1.setBackground(Color.decode("#22313F"));
		time1.setForeground(Color.WHITE);
		showTime.add(time1);

		time2 = new JButton("1(PM) - 4(PM)");
		time2.setFont(new Font("SansSerif", Font.BOLD, 15));
		time2.setBounds(175, 280, 150, 25);
		time2.setBackground(Color.decode("#22313F"));
		time2.setForeground(Color.WHITE);
		showTime.add(time2);

		time3 = new JButton("4(PM) - 7(PM)");
		time3.setFont(new Font("SansSerif", Font.BOLD, 15));
		time3.setBounds(340, 280, 150, 25);
		time3.setBackground(Color.decode("#22313F"));
		time3.setForeground(Color.WHITE);
		showTime.add(time3);

		time1.addActionListener(this);
		time2.addActionListener(this);
		time3.addActionListener(this);

		// --
		showTime.setLayout(null);
		//showTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showTime.setVisible(true);

		// --
		ArrayList<Movies> m = ServiceProvider.getMovies();
		byte[] imageRaw = new byte[] {};
		for (Movies mov : m) {
			if (mov.getMovieName().equalsIgnoreCase(movie)) {
				imageRaw = mov.getMovieImage();
			}
		}

		ImageIcon mImg = MovieShowcase.imageRefine(imageRaw, moviePic);
		moviePic.setIcon(mImg);

		// --

	}

	/*
	 * public static void main(String[] args) { ShowTiming sm = new ShowTiming();
	 * sm.displayTime("ddd"); }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == time1) {
			this.timeSelected = "10 to 1";
			ServiceProvider.setMovieTime(this.timeSelected);
			TicketBooking t = new TicketBooking();
			showTime.setVisible(false);
		}
		if (e.getSource() == time2) {
			this.timeSelected = "1 to 4";
			ServiceProvider.setMovieTime(this.timeSelected);
			TicketBooking t = new TicketBooking();
			showTime.setVisible(false);
		}
		if (e.getSource() == time3) {
			this.timeSelected = "4 to 7";
			ServiceProvider.setMovieTime(this.timeSelected);
			TicketBooking t = new TicketBooking();
			showTime.setVisible(false);
		}

	}

}
