package com.grsu.cherniavskij.horserace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grsu.cherniavskij.horserace.model.enums.StatusBet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class BetDTO {
    private Long id;

    private Date dateBet;
    private List<Long> events;
    private List<Long> accounts;
    private Double sum;

    private Double coefficientBet;

    private StatusBet statusBet;

    private Double calculate;

}
