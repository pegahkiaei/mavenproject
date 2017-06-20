package com.sbu.dao.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Pegah on 6/16/2017.
 */
@Entity
@Table(name = "CoMajt")
@XmlRootElement
@NamedQueries({
//TODO:named query
})
public class CoMajt implements Serializable {

    //-------------------------------------------------columnes
    @EmbeddedId
    private PKCoMajt id;
    //--------------------------------------------------relations
    @ManyToOne
    @MapsId("courseid") //This is the name of attr in PKStCot class
    @JoinColumn(name="coId", referencedColumnName="coId")
    private Cot course;

    @ManyToOne
    @MapsId("submajorid") //This is the name of attr in PKStCot class
    @JoinColumn(name="submajId", referencedColumnName="submajId")
    private SubMajt submajour;
    //-------------------------------------------------Constructors

    public CoMajt() {
    }

    public CoMajt(PKCoMajt id, Cot course, SubMajt submajour) {
        this.id = id;
        this.course = course;
        this.submajour = submajour;
    }

    //-------------------------------------------------getterSetters

    public PKCoMajt getId() {
        return id;
    }

    public void setId(PKCoMajt id) {
        this.id = id;
    }

    public Cot getCourse() {
        return course;
    }

    public void setCourse(Cot course) {
        this.course = course;
    }

    public SubMajt getSubmajour() {
        return submajour;
    }

    public void setSubmajour(SubMajt submajour) {
        this.submajour = submajour;
    }

    //-------------------------------------------------Overrides
}
