package com.sbu.controller.model;

/**
 * Created by Pegah on 6/24/2017.
 */
public class CourseDetail
{
    private Integer coid;
    private String  coname;
    private Integer cocredits;
    private float grade;
    private String stat;
    private String courseType;
    private boolean protest;

    public CourseDetail(Integer coid, String coname, Integer cocredits, float grade, String stat, String courseType, boolean protest) {
        this.coid = coid;
        this.coname = coname;
        this.cocredits = cocredits;
        this.grade = grade;
        this.stat = stat;
        this.courseType = courseType;
        this.protest = protest;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public Integer getCocredits() {
        return cocredits;
    }

    public void setCocredits(Integer cocredits) {
        this.cocredits = cocredits;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public boolean isProtest() {
        return protest;
    }

    public void setProtest(boolean protest) {
        this.protest = protest;
    }
}
