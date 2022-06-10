package com.webshop.backend.services;

import com.webshop.backend.entity.User;
import com.webshop.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));

        return userRepo.saveAndFlush(user);
    }

    public User validateUser(User user) {
        return userRepo.findByUsernameAndPassword(user.getUsername(), bcryptEncoder.encode(user.getPassword()));
    }
}
