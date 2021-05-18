package oopsdesign.bookmyshow.Movie_Show;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oopsdesign.bookmyshow.AccountRelated.Admin;

public class Movie {

	private String title;
	private String description;
	private String language;
	private String genre;
	private Date releaseDate;
	private Admin movieAddBy;
	private int durationInMinute;
	private List<Show> shows;

	public List<Show> getAllShows() {
		return new ArrayList<Show>();
	}

}
