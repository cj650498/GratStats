package com.gratstats.gratstats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a User with a role in the application.
 */
@Entity
@Table(name = "User")
public class User {

    public enum Role {
        ADMIN, KITCHEN, CASHIER, BOTH
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int id;

    @NotBlank(message = "First Name is required")
    @Column(name = "FirstName")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Column(name = "LastName")
    private String lastName;

    @Column(name = "UserName")
    private String username;

    @NotBlank(message = "Password is required")
    @Column(name = "Password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Role is required")
    @Column(name = "Role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tip> tips = new ArrayList<>();

    public User() {

    }

    public User(String firstName, String lastName, String username, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

     public List<Tip> getTips() {
        return tips;
     }

     public void setTips(List<Tip> tips) {
        this.tips = tips;
     }
}
