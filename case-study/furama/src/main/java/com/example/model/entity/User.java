package com.example.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRole> userRoleSet;
    public User() {
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
