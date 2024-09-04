package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);
}
