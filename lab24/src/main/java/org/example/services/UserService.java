package org.example.services;

import lombok.AllArgsConstructor;
import org.example.entities.User;
import org.example.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo repo;
    private PasswordEncoder passwordEncoder;

    public void createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }
}
