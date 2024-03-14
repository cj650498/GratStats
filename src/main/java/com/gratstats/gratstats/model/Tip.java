package com.gratstats.gratstats.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity class representing a Tip in the application.
 */
@Entity
@Table(name = "Tip")
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TipId")
    private int id;

    @Column(name = "MonetaryValue")
    private BigDecimal monetaryValue;

    @Column(name = "Date")
    private Date date;

    // Establishing a many-to-one relationship between Tip and User entities
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    public Tip() {
    }

    public Tip(BigDecimal monetaryValue, Date date, User user) {
        this.monetaryValue = monetaryValue;
        this.date = date;
        this.user = user;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(BigDecimal monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
