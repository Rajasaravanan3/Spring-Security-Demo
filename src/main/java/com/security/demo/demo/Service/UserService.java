package com.security.demo.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    public UserService() {
    }

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUsername(username);
        user.setPassword(encoder.encode(user.getPassword()));
        // if (user == null) {
        // throw new UsernameNotFoundException("Could not find user");
        // }
        return user;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
