package com.grsu.cherniavskij.horserace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grsu.cherniavskij.horserace.model.enums.ResultEvent;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Event {
    @Id
    @Column(nullable = false)
    private Long id;
    private String raceName ;
    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "event_id")
    private List<Horse> horses;
    private Date dateRegister;

    private Double coefficientEvent;

    private String bookmaker;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Double getCoefficientEvent() {
        return coefficientEvent;
    }

    public void setCoefficientEvent(Double coefficientEvent) {
        this.coefficientEvent = coefficientEvent;
    }

    public String getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(String bookmaker) {
        this.bookmaker = bookmaker;
    }

    public ResultEvent getResultEvent() {
        return resultEvent;
    }

    public void setResultEvent(ResultEvent resultEvent) {
        this.resultEvent = resultEvent;
    }

    private ResultEvent resultEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
