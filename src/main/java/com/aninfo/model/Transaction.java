package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double amount;
    private String type;
    private Long cbu;

    public Transaction(){
    }

    public Transaction(Double amount,String type, Long cbu){
        this.amount = amount;
        this.type = type;
        this.cbu = cbu;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Double getAmount(){
        return amount;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Long getCbu(){
        return cbu;
    }

    public void setCbu(Long cbu){
        this.cbu = cbu;
    }
}