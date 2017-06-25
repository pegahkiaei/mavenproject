package com.sbu.controller.model;

/**
 * Created by Pegah on 6/23/2017.
 */
public class TermDetail {
    String coursename;
    Float grade;
    String stat;
    Integer coirseId;

    public TermDetail(String coursename, Float grade, String status) {
        this.coursename = coursename;
        this.grade = grade;
        this.stat = status;

    }

    public TermDetail(String coursename, Float grade, String stat, Integer coirseId) {
        this.coursename = coursename;
        this.grade = grade;
        this.stat = stat;
        this.coirseId = coirseId;
    }

    public TermDetail() {
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Integer getCoirseId() {
        return coirseId;
    }

    public void setCoirseId(Integer coirseId) {
        this.coirseId = coirseId;
    }
}
