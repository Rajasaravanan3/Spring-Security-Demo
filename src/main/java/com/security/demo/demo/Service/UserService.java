package com.security.demo.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        user.setPassword(encoder.encode(user.getPassword()));
        return user;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
