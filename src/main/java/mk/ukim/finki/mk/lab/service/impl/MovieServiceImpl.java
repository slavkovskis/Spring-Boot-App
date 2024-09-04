package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.Movie;
import mk.ukim.finki.mk.lab.model.Production;
import mk.ukim.finki.mk.lab.repository.jpa.MovieRepository;
import mk.ukim.finki.mk.lab.repository.jpa.ProductionRepository;
import mk.ukim.finki.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> searchMovies(String text) {
        return movieRepository.findMovieBySummaryIsLike(text);
    }

    @Override
    public List<Movie> findMovieByTitleOrRating(String text, Double rating) {
        return movieRepository.findMovieByTitleOrRating(text, rating);
    }

    @Override
    public void addMovie(String title, String summary, Double rating, Long id, String productionName) {
        Optional<Production> productionOptional = productionRepository.findByName(productionName);
        if (productionOptional.isPresent()) {
            movieRepository.save((new Movie(title, summary, rating, id, productionOptional.get())));
        }
    }
    @Override
    public void editMovie(String title, String summary, Double rating, Long id, String productionName) {
        Optional<Production> productionOptional = productionRepository.findByName(productionName);
        if (productionOptional.isPresent()) {
            movieRepository.delete(movieRepository.findById(id).get());
            movieRepository.save((new Movie(title, summary, rating, id, productionOptional.get())));
        }
    }

    @Override
    public void deleteMovie(Long id) {
        this.movieRepository.deleteById(id);
    }


}
