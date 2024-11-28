package com.sonypiay.security.security_demo.service;

import com.sonypiay.security.security_demo.model.Users;
import com.sonypiay.security.security_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return userRepository.save(users);
    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                users.getUsername(),
                                users.getPassword()
                        )
                );

        System.out.println(authentication.isAuthenticated());

        if( authentication.isAuthenticated() ) {
            return jwtService.generateToken(users.getUsername());
        }

        return "fail";
    }
}
