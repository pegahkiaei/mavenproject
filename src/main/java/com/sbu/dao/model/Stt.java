/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;


import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pegah
 */
@Entity
@Table(name = "STT")
@XmlRootElement
@NamedQueries({//TODO:named query
    @NamedQuery(name = "Stt.findAll", query = "SELECT s FROM Stt s")
    , @NamedQuery(name = "Stt.findByName", query = "SELECT s FROM Stt s WHERE s.name = :name")
    , @NamedQuery(name = "Stt.findByUname", query = "SELECT s FROM Stt s WHERE s.uname = :uname")
    , @NamedQuery(name = "Stt.findById", query = "SELECT s FROM Stt s WHERE s.id = :id")})
public class Stt implements Serializable {
    //--------------------------------------------clumns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//TODO: how to gen
    @Column(name = "studentId", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;


    @Column(name = "uname",unique = true, nullable = false, length = 50)
    private String uname;

    @Column(name = "pass", nullable = false, length = 50)
    private String password;

    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Lob
    private Serializable photo;

    //-----------------------------------------------relations
    @ManyToOne(fetch = FetchType.EAGER)
    private Dept department;

    //stcot!
    @OneToMany(mappedBy = "course")
    private List<StCot> courses = new ArrayList<StCot>();

    @ManyToOne
    @JoinColumn(name = "submajId")
    private SubMajt submajour;


    //--------------------------------------------constructor
    public Stt() {

    }
    public Stt(String uname, String pass) {
        this.setUname(uname);
        this.setPassword(pass);
    }
    public Stt(Integer id) {
        this.id = id;
    }
    public Stt(Integer id, String name, String uname, String password) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
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
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    public List<StCot> getCourses() {
        return courses;
    }

    public void setCourses(List<StCot> courses) {
        this.courses = courses;
    }

    public SubMajt getSubmajour() {
        return submajour;
    }

    public void setSubmajour(SubMajt submajour) {
        this.submajour = submajour;
    }

    //--------------------------------------------Overrides
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stt)) {
            return false;
        }
        Stt other = (Stt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("uname: ").append(this.uname).append("; ");
        sb.append("pass: [PROTECTED]; ");

        return sb.toString();
    }
    
}
