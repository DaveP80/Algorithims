package com.logic.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Entry implements Serializable {

    private int id;

    public BigInteger value;

    public Entry(BigInteger value) { //useful constructor
        this.value = value;
    }


    public Entry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
