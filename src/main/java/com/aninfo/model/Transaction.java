package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionID;
    
    private Long cbu;
    private String type;
    private Double sum;

    public Transaction(Long ID, Long cbu, String type, Double amount) {
        this.transactionID = ID;
        this.cbu = cbu;
        this.type = type;
        this.sum = amount;
    }

    public Long getID(){
        return transactionID;
    }

    public Long getCbu() {
        return cbu;
    }

    public Double getSum() {
        return sum;
    }

    public String getType() {
        return type;
    }


}