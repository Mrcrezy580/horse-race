package com.grsu.cherniavskij.horserace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.grsu.cherniavskij.horserace.model.Horse;
import com.grsu.cherniavskij.horserace.model.enums.ResultEvent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDTO {

    private Long id;
    private String raceName ;
    private List<Long> horses;
    private Date dateRegister;
    private Double coefficientEvent;
    private String bookmaker;
    private ResultEvent resultEvent;
}
