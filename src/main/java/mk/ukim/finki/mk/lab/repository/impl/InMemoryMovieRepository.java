//package mk.ukim.finki.mk.lab.repository.impl;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.mk.lab.model.Movie;
//import mk.ukim.finki.mk.lab.model.Production;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryMovieRepository {
//
//    private final InMemoryProductionRepository inMemoryProductionRepository;
//    public static List<Movie> movieList = new ArrayList<>(10);
//
//    public InMemoryMovieRepository(InMemoryProductionRepository inMemoryProductionRepository) {
//        this.inMemoryProductionRepository = inMemoryProductionRepository;
//    }
//
//
//    @PostConstruct
//    public void init() {
//        movieList.add(new Movie("Betmen", "Betmen tepa loshi lugje", 9.0, inMemoryProductionRepository.findAll().get(0)));
//        movieList.add(new Movie("Supermen", "Supermen tepa loshi lugje", 8.0, inMemoryProductionRepository.findAll().get(1)));
//        movieList.add(new Movie("Spajdermen", "Spajdermen tepa loshi lugje", 7.0, inMemoryProductionRepository.findAll().get(2)));
//        movieList.add(new Movie("Ajronmen", "Ajronmen tepa loshi lugje", 3.0, inMemoryProductionRepository.findAll().get(3)));
//        movieList.add(new Movie("Vulverin", "Vulverin tepa loshi lugje", 5.6, inMemoryProductionRepository.findAll().get(4)));
//    }
//
//    public List<Movie> findAll(){
//        return movieList;
//    }
//
//    public Optional<Movie> findById(Long id) {
//        return movieList.stream().filter(l -> l.getId().equals(id)).findFirst();
//    }
//
//    public List<Movie> searchMovies(String text){
//        return movieList.stream().filter(l -> l.getTitle().contains(text) || l.getSummary().contains(text)).collect(Collectors.toList());
//    }
//
//    public List<Movie> filterMovies(double rating, String text){
//        return movieList.stream().filter(l -> l.getTitle().contains(text) || l.getSummary().contains(text) && l.getRating()>=rating).collect(Collectors.toList());
//    }
//
//    public Optional<Movie> addMovie(String title, String summary, Double rating, Long id, Production production){
//        Movie movie = new Movie(title, summary, rating, id, production);
//        movieList.add(movie);
//        return Optional.of(movie);
//    }
//
//    public Optional<Movie> editMovie(String title, String summary, Double rating, Long id, Long productionId) {
//        Movie movie = new Movie(title, summary, rating, id, inMemoryProductionRepository.findById(productionId).get());
//        movieList.removeIf(l -> l.getId().equals(id));
//        movieList.add(movie);
//        return Optional.of(movie);
//    }
//
//    public void deleteMovie(Long id) {
//        movieList.removeIf(l -> l.getId().equals(id));
//    }
//
////    public List<Movie> filterMovies(double rating){
////        return movieList.stream().filter(l -> l.getRating()>=rating).collect(Collectors.toList());
////    }
//}
