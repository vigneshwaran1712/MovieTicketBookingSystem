package com.example.movieticket.model;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN")
public class Admin {

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Id
    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @OneToOne
    @JoinColumn(name = "Email", referencedColumnName = "Username", foreignKey = @ForeignKey(name = "fk_admin_login"))
    private Login login;

    // Constructors, getters, and setters

    public Admin() {
    }

    public Admin(String name, String email, Login login) {
        this.name = name;
        this.email = email;
        this.login = login;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
