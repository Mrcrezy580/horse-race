package com.grsu.cherniavskij.horserace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grsu.cherniavskij.horserace.model.enums.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @Column(nullable = false)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;
    private String login;

    private String password;

    private Date dateRegisterAccount;

    private Status status;

    private Double balance;

    private String email;

    private Boolean isDelete;

    private String firstName;

    private String lastName;

    private Date dateBirth;

    private String address;

    public Long getId() {
        return id;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateRegisterAccount() {
        return dateRegisterAccount;
    }

    public void setDateRegisterAccount(Date dateRegisterAccount) {
        this.dateRegisterAccount = dateRegisterAccount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
