package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAll();

    Optional<Movie> findById(Long id);
    Optional<Movie> searchMovies(String text);

    List<Movie> findMovieByTitleOrRating(String text, Double rating);

    void addMovie(String title, String summary, Double rating, Long id, String productionName);
    void editMovie(String title, String summary, Double rating, Long id, String productionName);

    void deleteMovie(Long id);

}
