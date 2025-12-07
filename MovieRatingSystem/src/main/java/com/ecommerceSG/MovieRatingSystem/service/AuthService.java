package com.ecommerceSG.MovieRatingSystem.service;

import com.ecommerceSG.MovieRatingSystem.model.User;
import com.ecommerceSG.MovieRatingSystem.repository.UserRepository;
import com.ecommerceSG.MovieRatingSystem.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService service;

    @Autowired
    AuthenticationManager authenticationManager;

    public void register(User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(user.getRole());
        userRepository.save(user1);
        // TODO: encode password, save user
    }

    public String login(String username, String password) {
        // TODO: validate user
        // TODO: generate JWT (username + role)
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        if(authentication.isAuthenticated()){
            return service.generateToken(username);
        }
        return null;
    }
}
