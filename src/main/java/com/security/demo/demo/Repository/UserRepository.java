package com.security.demo.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.demo.demo.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("Select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
