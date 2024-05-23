package org.example.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.entities.User;
import org.example.repository.UserRepo;
import org.example.config.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo repository;
    UserDetailsServiceImpl(UserRepo repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(username);
        return user.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
