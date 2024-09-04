//package mk.ukim.finki.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.mk.lab.service.MovieService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.stream.Collectors;
//
//@WebServlet(name = "movie", urlPatterns = "/movie")
//public class MovieListServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final MovieService movieService;
//
//    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.movieService = movieService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("movies", movieService.listAll());
//        this.springTemplateEngine.process("listMovies.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String filter = req.getParameter("movieFilter");
//        double minRating = Double.parseDouble(req.getParameter("minRating"));
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("movies", movieService.filterMovies(minRating, filter));
//        this.springTemplateEngine.process("listMovies.html", context, resp.getWriter());
//
//    }
//}
