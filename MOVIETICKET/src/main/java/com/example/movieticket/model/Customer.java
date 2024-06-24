package com.example.movieticket.model;

import javax.persistence.*;
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Phone", nullable = false, length = 30)
    private String phone;

    @Column(name = "City", nullable = false, length = 30)
    private String city;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Email", referencedColumnName = "Username", foreignKey = @ForeignKey(name = "fk_customer_login"))
    private Login login;

    // Constructors, getters, and setters
    // Ensure to include constructors that initialize all fields, including Login

    public Customer() {
    }

    public Customer(String email, String name, String phone, String city, Login login) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }
    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
