package com.sbu.dao.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Pegah on 6/9/2017.
 */
@Entity
@Table(name = "Cot")
@XmlRootElement
@NamedQueries({
//        @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")//TODO:named query
})
public class Cot implements Serializable {

    //-------------------------------------------------columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//TODO:age ghararedasti generate konim bayad set beshe
    @Column(name = "coId", nullable = false)
    private Integer id;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "credit",nullable = false,length = 50)
    private int credit;

    @Column(name = "type",nullable = false,length = 50)
    private String type;

    //--------------------------------------------------relations
    @ManyToOne
    @JoinColumn
    private Dept courseDept;

    //stcot!!we cannot do like slides cuz em...coz we di need some more columns!more than just coid and stid!!
    @OneToMany(mappedBy = "student")
    private List<StCot> students = new ArrayList<StCot>();

    //termCourse!!we cannot do like slides cuz em...coz we di need some more columns!more than just coid and stid!!
    @OneToMany(mappedBy = "termCourse")
    private List<TermCot> termsCourses = new ArrayList<TermCot>();

    //-------------------------------------------------Constructors

    public Cot(){
    }
    public Cot(Integer id) {
        this.id = id;
    }

    //-------------------------------------------------getterSetters
    //TODO:getter-setter
    //-------------------------------------------------Overrides
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Cot other = (Cot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        return sb.toString();
    }
}
