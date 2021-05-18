package oopsdesign.bookmyshow;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Catalog implements Search {

	HashMap<String, List<Movie>> movieTitles;
	HashMap<String, List<Movie>> movieLanguages;
	HashMap<String, List<Movie>> movieGenres;
	HashMap<Date, List<Movie>> movieReleaseDates;
	HashMap<String, List<Movie>> movieCities;

	public List<Movie> searchByTitile(String title) {

		return movieTitles.get(title);
	}

	public List<Movie> searchByLanguage(String language) {

		return movieLanguages.get(language);
	}

	public List<Movie> searchByDate(Date releaseDate) {

		return movieReleaseDates.get(releaseDate);
	}

	public List<Movie> searchByGenre(String genre) {

		return movieGenres.get(genre);
	}

	public List<Movie> searchByCity(String city) {

		return movieCities.get(city);
	}

}
