package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface ShoppingCartService {

    Optional<ShoppingCart> findShoppingCartByUser(User user);
}
