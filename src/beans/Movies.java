package beans;

import java.io.Serializable;

public class Movies implements Serializable {

	private String movieName;
	private String movieType;
	private String movierating;
	private String movieDesc;
	private byte[] movieImage;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getMovierating() {
		return movierating;
	}

	public void setMovierating(String movierating) {
		this.movierating = movierating;
	}

	public String getMovieDesc() {
		return movieDesc;
	}

	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	public byte[] getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(byte[] movieImage) {
		this.movieImage = movieImage;
	}

}
