package com.itwn.entity;

import java.io.Serializable;

public class SecondType implements Serializable {
    private int id;
    private String secondTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondTypeName() {
        return secondTypeName;
    }

    public void setSecondTypeName(String secondTypeName) {
        this.secondTypeName = secondTypeName;
    }
}
