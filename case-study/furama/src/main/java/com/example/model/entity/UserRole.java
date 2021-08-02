package com.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRoleId;
    private int roleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usename")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;


    public UserRole() {
    }

    public UserRole(int userRoleId, int roleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.roleId = roleId;
        this.user = user;
        this.role = role;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
