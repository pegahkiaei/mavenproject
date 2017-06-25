package com.sbu.controller.model;

/**
 * Created by Nia on 6/25/2017.
 */
public class MyStudent {
    private String name;
    private int stid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public MyStudent(String name, int stid) {
        this.name = name;
        this.stid = stid;
    }
}
