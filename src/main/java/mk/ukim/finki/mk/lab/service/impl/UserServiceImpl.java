package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.repository.jpa.UserRepository;
import mk.ukim.finki.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
