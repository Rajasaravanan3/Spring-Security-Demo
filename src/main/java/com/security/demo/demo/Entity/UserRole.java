package com.security.demo.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}




// package com.security.demo.demo;

// import java.util.Collection;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;

// @Entity
// public class UserRole implements UserDetails {
    
//     @Autowired
//     private UserRoleService userRoleService;

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "user_role_id")
//     private Long userRoleId;

//     @OneToOne
//     @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//     private User user;

//     @OneToOne
//     @JoinColumn(name = "role_id", referencedColumnName = "role_id")
//     private Role role;

//     public UserRole() {}

//     public UserRole(Long userRoleId, User user, Role role) {
//         this.userRoleId = userRoleId;
//         this.user = user;
//         this.role = role;
//     }

//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return userRoleService.getRolesByUserId(this.getUser().getUserId());
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }

//     @Override
//     public String getPassword() {
//         return this.getUser().getPassword();
//     }

//     @Override
//     public String getUsername() {
//         return this.getUser().getUsername();
//     }

//     public Long getUserRoleId() {
//         return userRoleId;
//     }

//     public void setUserRoleId(Long userRoleId) {
//         this.userRoleId = userRoleId;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public Role getRole() {
//         return role;
//     }

//     public void setRole(Role role) {
//         this.role = role;
//     }
    
// }
