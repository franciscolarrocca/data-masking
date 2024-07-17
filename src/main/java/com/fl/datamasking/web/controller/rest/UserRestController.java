package com.fl.datamasking.web.controller.rest;

import com.fl.datamasking.domain.User;
import com.fl.datamasking.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository productRepository) {
        this.userRepository = productRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new NoSuchElementException(System.out.printf("The user with ID %d not exists.", id).toString());
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}