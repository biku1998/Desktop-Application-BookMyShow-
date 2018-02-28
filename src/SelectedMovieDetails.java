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
import javax.swing.JScrollPane;

import beans.Movies;

public class SelectedMovieDetails extends JFrame implements ActionListener {

	JFrame movieInfoPage;
	JLabel mNameL, mTypeL, mRatingL, mDescL, mDesc, title;
	JScrollPane jp;
	JButton back, next, mPhoto, trailer;
	String selectedMovie;

	void generateMovieInforamtion(String movieName) {
		this.selectedMovie = movieName;

		movieInfoPage = new JFrame("Movie Information");
		movieInfoPage.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon2.jpg")));

		movieInfoPage.setBounds(500, 100, 500, 470);
		movieInfoPage.getContentPane().setBackground(Color.decode("#FD7272"));
		movieInfoPage.setResizable(false);
		// --

		title = new JLabel(":: Movie Details ::");
		title.setFont(new Font("SansSerif", Font.BOLD, 20));
		title.setBounds(155, 10, 190, 25);
		title.setForeground(Color.white);
		movieInfoPage.add(title);

		mPhoto = new JButton();
		mPhoto.setBounds(315, 40, 150, 200);
		mPhoto.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		movieInfoPage.add(mPhoto);

		mNameL = new JLabel();
		mNameL.setBounds(25, 85, 180, 25);
		//mNameL.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		mNameL.setFont(new Font("SansSerif", Font.BOLD, 20));
		movieInfoPage.add(mNameL);

		mTypeL = new JLabel();
		mTypeL.setBounds(25, 145, 300, 25);
		//mTypeL.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		mTypeL.setFont(new Font("SansSerif", Font.BOLD, 20));
		movieInfoPage.add(mTypeL);

		mRatingL = new JLabel();
		mRatingL.setBounds(25, 205, 180, 25);
		//mRatingL.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		mRatingL.setFont(new Font("SansSerif", Font.BOLD, 20));
		movieInfoPage.add(mRatingL);

		mDesc = new JLabel("Description");
		mDesc.setFont(new Font("SansSerif", Font.BOLD, 20));
		mDesc.setBounds(25, 245, 150, 25);
		mDesc.setForeground(Color.white);
		movieInfoPage.add(mDesc);

		mDescL = new JLabel("");
		jp = new JScrollPane(mDescL);
		mDescL.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
		mDescL.setFont(new Font("SansSerif", Font.BOLD, 16));
		jp.setBounds(25, 275, 400, 65);
		movieInfoPage.add(jp);
		
		
		back = new JButton("Back");
		back.setBounds(25, 370, 100, 35);
		back.setBackground(Color.decode("#596275"));
		back.setForeground(Color.white);
		back.setFont(new Font("SansSerif", Font.BOLD, 16));
		movieInfoPage.add(back);
		back.addActionListener(this);
		
		
		trailer = new JButton("watch trailer");
		trailer.setBounds(145, 370, 160, 35);
		trailer.setBackground(Color.decode("#596275"));
		trailer.setForeground(Color.white);
		trailer.setFont(new Font("SansSerif", Font.BOLD, 16));
		movieInfoPage.add(trailer);
		trailer.addActionListener(this);
		
		
		
		next = new JButton("Next");
		next.setBounds(360, 370, 100, 35);
		next.setBackground(Color.decode("#596275"));
		next.setForeground(Color.white);
		next.setFont(new Font("SansSerif", Font.BOLD, 16));
		movieInfoPage.add(next);
		next.addActionListener(this);
		
		
		//-- data entry
		
		
		ArrayList<Movies> mov= ServiceProvider.getMovies();
		String movName = "";
		String movType = "";
		String movRating = "";
		String movDesc = "";
		byte[] image = new byte[]{};
		
		for (Movies m : mov) {
			
			if(movieName.equalsIgnoreCase(m.getMovieName())) {
				 movName = m.getMovieName();
				 movType = m.getMovieType();
				 movRating = m.getMovierating();
				 movDesc =  m.getMovieDesc();
				 image = m.getMovieImage();
 			}
		}
		
		
		mNameL.setText(movName);
		mTypeL.setText(movType);
		mRatingL.setText(movRating);
		mDescL.setText(movDesc);
		
		ImageIcon ic = MovieShowcase.imageRefine(image, mPhoto);
		
		mPhoto.setIcon(ic);
		
		
		
		
		
		
		
		//--
		

		// --

		movieInfoPage.setLayout(null);
		movieInfoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movieInfoPage.setVisible(true);

	}

	/*public static void main(String[] args) {
		SelectedMovieDetails obj = new SelectedMovieDetails();
		obj.generateMovieInforamtion("hh");
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == back) {
			movieInfoPage.setVisible(false);
			MovieShowcase ref = new MovieShowcase();
		}
		if(e.getSource() == next) {
			
			ShowTiming sm = new ShowTiming();
			sm.displayTime(this.selectedMovie);
			
			
		}
		if(e.getSource()== trailer) {
			try {
				String r = mNameL.getText().toString();

				if(r.equalsIgnoreCase("the martian")) {
					r = "TheMartian";
				}

				if(r.equalsIgnoreCase("wonder woman")) {
					r = "WonderWoman";
				}
				
				if(r.equalsIgnoreCase("black panther")) {
					r = "BlackPanther";
				}
				if(r.equalsIgnoreCase("jurassic world")) {
					r = "JurassicWorld";
				}
				
				
				Runtime rt = Runtime.getRuntime();
				rt.exec("cmd /c start G:/BMS(Images)/trailer/"+r+".mkv");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
