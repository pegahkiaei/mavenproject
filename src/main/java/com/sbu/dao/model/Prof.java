/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pegah
 */
@Entity

@Table(name = "PROF")
@XmlRootElement
@NamedQueries({//TODO:named query
    @NamedQuery(name = "Prof.findAll", query = "SELECT p FROM Prof p")
    , @NamedQuery(name = "Prof.findById", query = "SELECT p FROM Prof p WHERE p.id = :id")
    , @NamedQuery(name = "Prof.findByName", query = "SELECT p FROM Prof p WHERE p.name = :name")
    , @NamedQuery(name = "Prof.findByUname", query = "SELECT p FROM Prof p WHERE p.uname = :uname")
    , @NamedQuery(name = "Prof.findByPass", query = "SELECT p FROM Prof p WHERE p.pass = :pass")
    , @NamedQuery(name = "Prof.findByEmail", query = "SELECT p FROM Prof p WHERE p.email = :email")
    , @NamedQuery(name = "Prof.findByDid", query = "SELECT p FROM Prof p WHERE p.id = :did")})
public class Prof implements Serializable {

    //----------------------------------------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profId", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 50)//TODO:how to gen?
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNAME",unique = true, nullable = false, length = 50)
    private String uname;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASS", nullable = false, length = 50)
    private String pass;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Lob
    @Column(name = "image")
    private Serializable photo;

    //--------------------------------------------------relations
    @ManyToOne(fetch = FetchType.EAGER)
    private Dept department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseProfessor", orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<TermCot> courses = new ArrayList<>();
    //-------------------------------------------------Constructor
    public Prof() {
    }
    public Prof(Integer id) {
        this.id = id;
    }
    public Prof(Integer id, String name, String uname, String pass, String email, Serializable image, int did) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.email = email;
        this.photo = image;
    }
    //-------------------------------------------------getterSetters


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Serializable getPhoto() {
        return photo;
    }

    public void setPhoto(Serializable photo) {
        this.photo = photo;
    }

    public Dept getDepartment() {
        return department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    public List<TermCot> getCourses() {
        return courses;
    }

    public void setCourses(List<TermCot> termCourses) {
        this.courses = termCourses;
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
        if (!(object instanceof Prof)) {
            return false;
        }
        Prof other = (Prof) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.sbu.dao.model.Prof[ id=" + id + " ]";
    }
    
}
