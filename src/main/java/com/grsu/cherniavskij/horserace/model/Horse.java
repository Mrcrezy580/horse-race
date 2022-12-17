package com.grsu.cherniavskij.horserace.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;

    private Integer age;

    private Integer equipmentWeight;

    private String formEn;

    private String formRu;

    private String owner;
}
