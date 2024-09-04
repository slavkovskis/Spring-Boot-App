package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public Optional<ShoppingCart> findShoppingCartByUser(User user) {
        return shoppingCartRepository.findShoppingCartByUser(user);
    }
}
