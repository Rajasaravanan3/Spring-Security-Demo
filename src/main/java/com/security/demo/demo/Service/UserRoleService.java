package com.security.demo.demo.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Repository.UserRoleRepository;

@Service
public class UserRoleService {
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    public Set<User> getRolesByUserId(Long userId) {
        return userRoleRepository.findRolesByUserId(userId);
    }
}
