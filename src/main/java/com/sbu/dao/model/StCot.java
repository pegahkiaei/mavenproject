package com.sbu.dao.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pegah on 6/10/2017.
 */
@Entity
@Table(name="StCot")
public class StCot implements Serializable {
    //-------------------------------------------------columnes
    @EmbeddedId
    private PKStCot id;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "grade")
    private Float grade;

    //--------------------------------------------------relations
    @ManyToOne
    @MapsId("student") //This is the name of attr in PKStCot class
    @JoinColumn(name="stId", referencedColumnName="studentId")
    private Stt student;

    @ManyToOne
    @MapsId("course") //This is the name of attr in PKStCot class
    @JoinColumn(name="couId", referencedColumnName="coId")
    private Cot course;

    //-------------------------------------------------Constructors

    public StCot() {
    }

    public StCot(Integer stId, Integer coId, int term, Float grade, Stt student, Cot course) {
        this.term = term;
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    //-------------------------------------------------getterSetters

    public PKStCot getId() {
        return id;
    }

    public void setId(PKStCot id) {
        this.id = id;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Stt getStudent() {
        return student;
    }

    public void setStudent(Stt student) {
        this.student = student;
    }

    public Cot getCourse() {
        return course;
    }

    public void setCourse(Cot course) {
        this.course = course;
    }

    //-------------------------------------------------Overrides
    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
//        StCot other = (StCot) object;
//        if ((this.coId == null && other.coId != null) || (this.coId != null && !this.coId.equals(other.coId)) &&
//                (this.stId == null && other.stId != null) || (this.stId != null && !this.stId.equals(other.stId))) {
//            return false;
//        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        return sb.toString();
    }

}
