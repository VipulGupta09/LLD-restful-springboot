package oopsdesign.bookmyshow;

import java.util.Date;
import java.util.List;

public interface Search {

	public List<Movie> searchByTitile(String title);
	public List<Movie> searchByLanguage(String language);
	public List<Movie> searchByDate(Date releaseDate);
	public List<Movie> searchByGenre(String genre);
	public List<Movie> searchByCity(String city);
}
