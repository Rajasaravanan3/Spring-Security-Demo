package com.security.demo.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.demo.demo.Entity.Role;
import com.security.demo.demo.Entity.User;
import com.security.demo.demo.Entity.UserRole;

import java.util.Set;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("Select u from User u inner join UserRole ur on u.userId = ur.user.userId inner join Role r on ur.role.roleId = r.roleId where u.userId = :userId")
    Set<User> findRolesByUserId(@Param("userId") Long userId);

    @Query("Select u from User u inner join UserRole ur on u.userId = ur.user.userId inner join Role r on ur.role.roleId = r.roleId where r.roleId = :roleId")
    Set<Role> findUsersByRoleId(@Param("roleId") Long roleId);

}
