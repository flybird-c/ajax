package com.itwn.entity;

import java.io.Serializable;

public class FirstType implements Serializable {
    private int id;
    private String firstTypeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstTypeName() {
        return firstTypeName;
    }

    public void setFirstTypeName(String firstTypeName) {
        this.firstTypeName = firstTypeName;
    }
}
