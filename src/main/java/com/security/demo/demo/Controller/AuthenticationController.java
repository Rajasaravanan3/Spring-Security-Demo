package com.security.demo.demo.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.demo.Entity.JwtAuthenticationResponse;
import com.security.demo.demo.Entity.RefreshTokenRequest;
import com.security.demo.demo.Entity.SignInRequest;
import com.security.demo.demo.Entity.SignUpRequest;
import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {

        return new ResponseEntity<>(authenticationService.signUp(signUpRequest), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.signIn(signInRequest), HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) throws Exception {
        return new ResponseEntity<>(authenticationService.refreshToken(refreshTokenRequest), HttpStatus.OK);
    }
}
