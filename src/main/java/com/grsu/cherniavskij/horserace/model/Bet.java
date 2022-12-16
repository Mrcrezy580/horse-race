package com.grsu.cherniavskij.horserace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grsu.cherniavskij.horserace.model.enums.StatusBet;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Bet {
    @Id
    @Column(nullable = false)
    private Long id;

    private Date dateBet;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "bet_id")
    private List<Event> events;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "bet_id")
    private List<Account> accounts;

    public Date getDateBet() {
        return dateBet;
    }

    public void setDateBet(Date dateBet) {
        this.dateBet = dateBet;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getCoefficientBet() {
        return coefficientBet;
    }

    public void setCoefficientBet(Double coefficientBet) {
        this.coefficientBet = coefficientBet;
    }

    public StatusBet getStatusBet() {
        return statusBet;
    }

    public void setStatusBet(StatusBet statusBet) {
        this.statusBet = statusBet;
    }

    public Double getCalculate() {
        return calculate;
    }

    public void setCalculate(Double calculate) {
        this.calculate = calculate;
    }

    private Double sum;

    private Double coefficientBet;

    private StatusBet statusBet;

    private Double calculate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
