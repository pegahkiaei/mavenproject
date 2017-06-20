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

    //coursePreCourse(each course has some preCourses and each course can be the preCourse of some Courses!!!!)
    @ManyToMany(mappedBy = "preRequisiteCourses")//in dar pishniyaze che darsaeiye
    private List<Cot> preRequisiteCourseFor = new ArrayList<Cot>();

    @ManyToMany
            @JoinTable(name="PreCot",
                    joinColumns=@JoinColumn(name="maincoId",referencedColumnName="coId"),
                    inverseJoinColumns=@JoinColumn(name="preCoId", referencedColumnName="coId"))//in dars che pishniyazaei dare
    private List<Cot> preRequisiteCourses = new ArrayList<Cot>();


    //-------------------------------------------------Constructors

    public Cot(){
    }
    public Cot(Integer id) {
        this.id = id;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Dept getCourseDept() {
        return courseDept;
    }

    public void setCourseDept(Dept courseDept) {
        this.courseDept = courseDept;
    }

    public List<StCot> getStudents() {
        return students;
    }

    public void setStudents(List<StCot> students) {
        this.students = students;
    }

    public List<TermCot> getTermsCourses() {
        return termsCourses;
    }

    public void setTermsCourses(List<TermCot> termsCourses) {
        this.termsCourses = termsCourses;
    }

    public List<Cot> getPreRequisiteCourseFor() {
        return preRequisiteCourseFor;
    }

    public void setPreRequisiteCourseFor(List<Cot> preRequisiteCourseFor) {
        this.preRequisiteCourseFor = preRequisiteCourseFor;
    }

    public List<Cot> getPreRequisiteCourses() {
        return preRequisiteCourses;
    }

    public void setPreRequisiteCourses(List<Cot> preRequisiteCourses) {
        this.preRequisiteCourses = preRequisiteCourses;
    }

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
