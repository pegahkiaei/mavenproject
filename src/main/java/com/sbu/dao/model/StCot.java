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
    private int grade;

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

    public StCot(Integer stId, Integer coId, int term, int grade, Stt student, Cot course) {
        this.term = term;
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    //-------------------------------------------------getterSetters
    //TODO:getter-setter
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
