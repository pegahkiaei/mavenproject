package com.sbu.controller.model;

/**
 * Created by Nia on 6/25/2017.
 */
public class Courses {
    private String name;
    private int coid;
    private int cgid;

    public Courses(String name, int coid,int cgid) {
        this.name = name;
        this.coid = coid;
        this.cgid = cgid;
    }

    public String getName() {
        return name;
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getCgid() {
        return cgid;
    }

    public void setCgid(int cgid) {
        this.cgid = cgid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCid() {
        return coid;
    }

    public void setCid(int coid) {
        this.coid = coid;
    }
}
