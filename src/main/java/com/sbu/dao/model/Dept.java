/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pegah
 */
@Entity
@Table(name = "DEPT")
@XmlRootElement
@NamedQueries({//TODO:named query
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
    , @NamedQuery(name = "Dept.findByDid", query = "SELECT d FROM Dept d WHERE d.id = :did")
    , @NamedQuery(name = "Dept.findByName", query = "SELECT d FROM Dept d WHERE d.name = :name")
    , @NamedQuery(name = "Dept.findByUname", query = "SELECT d FROM Dept d WHERE d.uname = :uname")
    , @NamedQuery(name = "Dept.findByPasswoed", query = "SELECT d FROM Dept d WHERE d.password = :passwoed")})
public class Dept implements Serializable {

    //----------------------------------------------------------columns
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//TODO:age ghararedasti generate konim bayad set beshe
    @Column(name = "depId", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    
    @Basic(optional = false)
    @Column(name = "uname",unique = true, nullable = false, length = 50)
    private String uname;
    
    @Basic(optional = false)
    @Column(name = "pass", nullable = false, length = 50)
    private String password;


    //-------------------------------------------------------------relations
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
    private List<Stt> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
    private List<Prof> professors = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="managerId")
    private Prof manager;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "courseDept")
    private Set<Cot> deptCourses;



    //--------------------------------------------------------------constructors
    public Dept() {
    }
    public Dept(Integer did) {
        this.id = did;
    }
    public Dept(Integer did, String name, String uname, String password) {
        this.id = did;
        this.name = name;
        this.uname = uname;
        this.password = password;
    }

    //---------------------------------------------------------setters ansd getters

    //-----------------------------------------------------------Overrides
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
        Dept other = (Dept) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sbu.dao.model.Dept[ id=" + id + " ]";
    }
    
}
