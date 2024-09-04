package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.Movie;
import mk.ukim.finki.mk.lab.model.Production;
import mk.ukim.finki.mk.lab.service.MovieService;
import mk.ukim.finki.mk.lab.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final ProductionService productionService;

    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService = productionService;
    }

    @GetMapping()
    public String getMoviesPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }

    @PostMapping("/add")
    public String saveMovie(@RequestParam String title,
                            @RequestParam String summary,
                            @RequestParam Double rating,
                            @RequestParam Long id,
                            @RequestParam String productionName){
        try {
            movieService.addMovie(title, summary, rating, id, productionName);
            return "redirect:/movies";
        }catch(IllegalArgumentException exception){
            exception.getMessage();
            return "listMovies";
        }
    }

    @PostMapping("/edit/{movieId}")
    public String editMovie(@PathVariable Long movieId,
                            @RequestParam String title,
                            @RequestParam String summary,
                            @RequestParam Double rating,
                            @RequestParam String productionName){
        movieService.editMovie(title, summary, rating, movieId, productionName);
        return "redirect:/movies";
    }

    //MOZHE I GET I POST NA IST PATH TAKA SHO PRVEN PRAVISH HREF (SHO E ISTO KO GET) NA TAA PATEKA SE POVIKUVA GET SHO E DOLE I POSLE TOA SE PRAVI
    //POST METODOT KOGA SI GOTOV SO GET

    @GetMapping("/edit/{id}")
    public String editMoviePage(@PathVariable Long id, Model model){
        Optional<Movie> movie = movieService.findById(id);
        model.addAttribute("movie", movie.get());
        List<Production> productions = productionService.findAll();
        model.addAttribute("productions",productions);
        return "add-movie";
    }

//    <a th:href="@{'/movies/edit/' + ${movie.id}}"><button type="button">Edit</button></a>
//    <a th:href="@{'/movies/delete/' + ${movie.id}}" onclick="return confirm('Are you sure you want to delete this movie?')"><button type="button">Delete</button></a>

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, Model model){
        movieService.deleteMovie(id);
        model.addAttribute("movies", movieService.listAll());
        return "redirect:/movies";
    }

}
