package com.sbu.dao.model;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Pegah on 6/10/2017.
 */
@Entity
@Table(name="TermCot")
public class TermCot implements Serializable {
    //-------------------------------------------------columnes
    @EmbeddedId
    private PKTermCot id;


    //filterId
    //--------------------------------------------------relations

    @ManyToOne(fetch = FetchType.EAGER)
    private Prof courseProfessor;


    @ManyToOne
    @MapsId("course") //This is the name of attr in PKStCot class
    @JoinColumn(name="coId", referencedColumnName="coId")
    private Cot termCourse;

    //-------------------------------------------------Constructors


    public TermCot() {
    }

    public TermCot(PKTermCot id, Prof courseProfessor, Cot termCourse) {
        this.id = id;
        this.courseProfessor = courseProfessor;
        this.termCourse = termCourse;
    }

    public TermCot(Integer term, Cot course) {
        this.id = new PKTermCot(term);
        termCourse = course;
    }

    //-------------------------------------------------getterSetters
    //TODO:getter-setter
    //-------------------------------------------------Overrides


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TermCot)) return false;

        TermCot termCot = (TermCot) o;

        if (!id.equals(termCot.id)) return false;
        return termCourse.equals(termCot.termCourse);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + termCourse.hashCode();
        return result;
    }
}
