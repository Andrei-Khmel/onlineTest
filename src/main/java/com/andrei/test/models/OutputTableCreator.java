package com.andrei.test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OutputTableCreator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private int extraversion;
    private int neuroticism;
    private int deceit;

    public OutputTableCreator() {
    }
    public OutputTableCreator(String idCode, int extraversion, int neuroticism, int deceit) {
        this.code = idCode;
        this.extraversion = extraversion;
        this.neuroticism = neuroticism;
        this.deceit = deceit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String idCode) {
        this.code = idCode;
    }

    public int getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(int extraversion) {
        this.extraversion = extraversion;
    }

    public int getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(int neuroticism) {
        this.neuroticism = neuroticism;
    }

    public int getDeceit() {
        return deceit;
    }

    public void setDeceit(int deceit) {
        this.deceit = deceit;
    }
}
