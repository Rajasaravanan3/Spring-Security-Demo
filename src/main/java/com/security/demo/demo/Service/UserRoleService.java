package com.security.demo.demo.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.demo.demo.Entity.Role;
import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Entity.UserRole;
import com.security.demo.demo.Repository.UserRoleRepository;

@Service
public class UserRoleService {//} implements UserDetailsService{
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    public Set<User> getRolesByUserId(Long userId) {
        return userRoleRepository.findRolesByUserId(userId);
    }

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     UserRole userRole =
    // }
}
