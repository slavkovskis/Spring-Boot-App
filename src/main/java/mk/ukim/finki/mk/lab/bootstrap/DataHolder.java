package mk.ukim.finki.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.mk.lab.model.*;
import mk.ukim.finki.mk.lab.repository.jpa.MovieRepository;
import mk.ukim.finki.mk.lab.repository.jpa.ProductionRepository;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataHolder {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;
    private final UserRepository userRepository;

    private final ShoppingCartRepository shoppingCartRepository;


    @PostConstruct
    public void init() {

        if(userRepository.findAll().size() == 0) {
            PersonName personName = new PersonName("Slave", "Slavkovski");
            userRepository.save(new User("username", personName, "password", LocalDate.of(2002, 11, 23)));
            User user = userRepository.findUserByUsername("username").get();
            shoppingCartRepository.save(new ShoppingCart(user));
        }


        if (productionRepository.findAll().size() == 0) {
            productionRepository.save(new Production("Televizija Zdravkin", "Macedonia", "Veles"));
            productionRepository.save(new Production("Disney", "India", "Mumbai"));
            productionRepository.save(new Production("Universal Studios", "England", "London"));
            productionRepository.save(new Production("Bethesda", "Sweden", "Malmo"));
            productionRepository.save(new Production("Rockstar Games", "USA", "San Francisco"));
        }

        if (movieRepository.findAll().size() == 0) {
            movieRepository.save(new Movie("Betmen", "Betmen tepa loshi lugje", 9.0, productionRepository.findAll().get(0)));
            movieRepository.save(new Movie("Supermen", "Supermen tepa loshi lugje", 8.0, productionRepository.findAll().get(1)));
            movieRepository.save(new Movie("Spajdermen", "Spajdermen tepa loshi lugje", 7.0, productionRepository.findAll().get(2)));
            movieRepository.save(new Movie("Ajronmen", "Ajronmen tepa loshi lugje", 3.0, productionRepository.findAll().get(3)));
            movieRepository.save(new Movie("Vulverin", "Vulverin tepa loshi lugje", 5.6, productionRepository.findAll().get(4)));
        }
    }
}
