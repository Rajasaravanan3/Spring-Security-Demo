package com.security.demo.demo.Service;

import com.security.demo.demo.Entity.User;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.demo.Entity.JwtAuthenticationResponse;
import com.security.demo.demo.Entity.RefreshTokenRequest;
import com.security.demo.demo.Entity.SignInRequest;
import com.security.demo.demo.Entity.SignUpRequest;
import com.security.demo.demo.Repository.UserRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public User signUp(SignUpRequest signUpRequest) {

        User user = new User();
        user.setFullName(signUpRequest.getFullName());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setIsActive(true);
        // only admin can set role to user
        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) throws Exception {

        User user = userRepository.findByUsername(signInRequest.getUsername());
        if (user == null) {
            throw new Exception("Invalid email or password");
        }

        // authenticationManager.authenticate(
        // new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
        // signInRequest.getPassword()));

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setAccessToken(accessToken);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshToken) throws Exception{

        String username = jwtService.extractUserName(refreshToken.getRefreshToken());
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new Exception("invalid refresh token");
        }
        
        if(jwtService.isTokenValid(refreshToken.getRefreshToken(), user)) {
            
            String accessToken = jwtService.generateAccessToken(user);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setAccessToken(accessToken);
            jwtAuthenticationResponse.setRefreshToken(refreshToken.getRefreshToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

}
