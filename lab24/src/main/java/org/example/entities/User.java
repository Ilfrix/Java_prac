package org.example.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String name;

    @Column
    public String password;

    @Column
    public String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User(String name, String password, String roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    public User(Long id, String name, String password, String roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }
}
