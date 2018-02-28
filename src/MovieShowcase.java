
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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import beans.Movies;

public class MovieShowcase extends JFrame implements ActionListener {

	JFrame movieShow;
	JButton btnNext;
	JButton mainImage;
	JButton backImage,nextImage;
	JLabel movieNameL, logo, title;
	String logopath = "icons/appicon2.jpg";
	String nexticon = "icons/next.png";
	//String preicon = "G:\\BMS(Images)\\previous.png";

	// -- data
	ArrayList<byte[]> imageArray = new ArrayList<byte[]>();
	String[] movName = new String[] {};
	int pos;

	ImageIcon main, left, right;

	static ImageIcon imageRefine(byte[] imageRaw, JButton btn) {

		ImageIcon raw = new ImageIcon(imageRaw);
		Image filterimg = raw.getImage();
		Image myimg = filterimg.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon freshImage = new ImageIcon(myimg);

		return freshImage;

	}

	public MovieShowcase() {

		movieShow = new JFrame("Movie Avaliable");
		movieShow.setBounds(340, 70, 500, 600);
		movieShow.setResizable(false);
		movieShow.getContentPane().setBackground(Color.white);
		movieShow.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("appicon.jpg")));

		// --

		logo = new JLabel();
		logo.setBounds(190, 6, 100, 100);
		ImageIcon logoimg = new ImageIcon(logopath);
		logo.setIcon(logoimg);
		movieShow.add(logo);

		title = new JLabel("Select Movie");
		title.setFont(new Font("SansSerif", Font.BOLD, 20));
		title.setBounds(180, 100, 160, 35);
		movieShow.add(title);

		mainImage = new JButton();
		mainImage.setBounds(140, 150, 200, 300);
		mainImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4, true));
		movieShow.add(mainImage);
		mainImage.addActionListener(this);

		backImage = new JButton();
		backImage.setBounds(35, 190, 100, 200);
		backImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		movieShow.add(backImage);

		nextImage = new JButton();
		nextImage.setBounds(345, 190, 100, 200);
		nextImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		movieShow.add(nextImage);

		btnNext = new JButton("ddddd");
		btnNext.setBounds(206, 495, 70, 70); // 140, 480, 64, 64
		ImageIcon icnext = new ImageIcon(nexticon);
		btnNext.setIcon(icnext);
		btnNext.setBackground(Color.white);
		btnNext.setBorderPainted(false);
		movieShow.add(btnNext);
		btnNext.addActionListener(this);

		movieNameL = new JLabel("Name");
		movieNameL.setBounds(170, 455, 180, 35);
		movieNameL.setFont(new Font("SansSerif", Font.BOLD, 15));
		movieShow.add(movieNameL);


		// --

		movieShow.setLayout(null);
		movieShow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movieShow.setVisible(true);
		setImage();

	}

	/*public static void main(String[] args) {
		MovieShowcase m = new MovieShowcase();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainImage) {
			
			SelectedMovieDetails selm = new SelectedMovieDetails();
			selm.generateMovieInforamtion(this.movName[pos]);
			movieShow.setVisible(false);
			
		}

		if (e.getSource() == btnNext) {

			nextButtonAction();

		}


	}

	private void nextButtonAction() {

		pos++;

		if (this.pos >= movName.length) {
			pos = 0;
			setImage();
		} else {

			String mName = movName[pos];
			byte[] imageDataMain = imageArray.get(pos);
			byte[] imageDataRight = imageArray.get(pos - 1);
			byte[] imageDataLeft = new byte[] {};
			if (this.pos == movName.length - 1) {

				imageDataLeft = imageArray.get(0);
			} else {
				imageDataLeft = imageArray.get(pos + 1);
			}

			main = imageRefine(imageDataMain, mainImage);
			mainImage.setIcon(main);

			movieNameL.setText(mName);

			// -- left

			left = imageRefine(imageDataLeft, backImage);
			backImage.setIcon(left);

			// -- right

			right = imageRefine(imageDataRight, nextImage);
			nextImage.setIcon(right);
		}

	}

	private void setImage() {

		String movieName = "";

		ArrayList<Movies> movieList = ServiceProvider.getMovies();

		for (Movies mov : movieList) {

			movieName = movieName + mov.getMovieName() + ",";

			imageArray.add(mov.getMovieImage());

		}

		this.movName = movieName.split(",");

		pos = 0;

		String mName = movName[pos];

		byte[] imageDataMain = imageArray.get(pos);

		byte[] imageDataLeft = imageArray.get(pos + 1);
		byte[] imageDataRight = imageArray.get(movName.length - 1);

		main = imageRefine(imageDataMain, mainImage);
		mainImage.setIcon(main);

		movieNameL.setText(mName);

		// -- left

		left = imageRefine(imageDataLeft, backImage);
		backImage.setIcon(left);

		// -- right

		right = imageRefine(imageDataRight, nextImage);
		nextImage.setIcon(right);

	}

}
