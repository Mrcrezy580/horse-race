package com.grsu.cherniavskij.horserace.model;

import javax.persistence.*;

@Entity
public class Horse {
    @Id
    @Column(nullable = false)
    private Long id;
    private String nickName;

    private Integer age;

    private Integer equipmentWeight;

    private String formEn;

    private String formRu;

    private String owner;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(Integer equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }

    public String getFormEn() {
        return formEn;
    }

    public void setFormEn(String formEn) {
        this.formEn = formEn;
    }

    public String getFormRu() {
        return formRu;
    }

    public void setFormRu(String formRu) {
        this.formRu = formRu;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
