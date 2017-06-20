package com.sbu.dao.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Pegah on 6/16/2017.
 */
@Entity
@Table(name = "SubMajT")
@XmlRootElement
@NamedQueries({
//        @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")//TODO:named query
})
public class SubMajt implements Serializable {

    //-------------------------------------------------columnes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//TODO:age ghararedasti generate konim bayad set beshe
    @Column(name = "submajId", nullable = false)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;
    //--------------------------------------------------relations
   // @Id//TODO:IS THIS POSSIBLEEEEEEEEEEEEEEE?!
    @ManyToOne
    @JoinColumn(name = "depId")
    private Dept department;
    //-------------------------------------------------Constructors

    public SubMajt() {
    }

    public SubMajt(String name, Dept department) {
        this.name = name;
        this.department = department;
    }

    //-------------------------------------------------getterSetters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDepartment() {
        return department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    //-------------------------------------------------Overrides
}
