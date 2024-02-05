package com.security.demo.demo.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Service.UserRoleService;
import com.security.demo.demo.Service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable("username") String username) {
        
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<User>> getRolesByUserId(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(userRoleService.getRolesByUserId(userId), HttpStatus.OK);
    }

}
