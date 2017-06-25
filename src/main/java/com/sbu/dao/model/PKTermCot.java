package com.sbu.dao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by Pegah on 6/11/2017.
 */
@Embeddable
public class PKTermCot implements Serializable {

    @Column(name = "coid")
    private Integer course;

    @Column(name = "term")
    private Integer term;

    @Column(name="year")
    private Integer year;

//TODO:warning!what to do with cgid and term
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cgid")
    private Integer coursegroup;


    public PKTermCot(Integer term) {
        this.term = term;
    }

    public PKTermCot() {
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCoursegroup() {
        return coursegroup;
    }

    public void setCoursegroup(Integer coursegroup) {
        this.coursegroup = coursegroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKTermCot)) return false;

        PKTermCot pkTermCot = (PKTermCot) o;

        if (!getCourse().equals(pkTermCot.getCourse())) return false;
        if (!getTerm().equals(pkTermCot.getTerm())) return false;
        return getCoursegroup().equals(pkTermCot.getCoursegroup());

    }

    @Override
    public int hashCode() {
        int result = getCourse().hashCode();
        result = 31 * result + getTerm().hashCode();
        result = 31 * result + getCoursegroup().hashCode();
        return result;
    }
}