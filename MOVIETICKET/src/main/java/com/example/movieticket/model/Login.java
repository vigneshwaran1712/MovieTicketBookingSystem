
package com.example.movieticket.model;
import javax.persistence.*;

@Entity
@Table(name = "LOGIN")
public class Login {

    @Id
    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Column(name = "Password", nullable = false, length = 50)
    private String password;

    @Column(name = "Admin", nullable = false)
    private boolean admin;

    // Constructors

    public Login() {
    }

    public Login(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    // Getters and setters

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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    // toString() method (optional but recommended for logging/debugging)

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
