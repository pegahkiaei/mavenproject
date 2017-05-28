/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pegah
 */
@Entity
@Table(name = "STT", catalog = "NEET", schema = "PUBLIC", uniqueConstraints = {
//    @UniqueConstraint(columnNames = {"MAJOR"})
//    , @UniqueConstraint(columnNames = {"SUBMAJOR"})
     @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stt.findAll", query = "SELECT s FROM Stt s")
    , @NamedQuery(name = "Stt.findByName", query = "SELECT s FROM Stt s WHERE s.name = :name")
    , @NamedQuery(name = "Stt.findByUname", query = "SELECT s FROM Stt s WHERE s.uname = :uname")
    , @NamedQuery(name = "Stt.findByPassword", query = "SELECT s FROM Stt s WHERE s.password = :password")
//    , @NamedQuery(name = "Stt.findByMajor", query = "SELECT s FROM Stt s WHERE s.major = :major")
//    , @NamedQuery(name = "Stt.findBySubmajor", query = "SELECT s FROM Stt s WHERE s.submajor = :submajor")
    , @NamedQuery(name = "Stt.findById", query = "SELECT s FROM Stt s WHERE s.id = :id")})
public class Stt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME", nullable = false, length = 50, columnDefinition="default 'a'")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UNAME", nullable = false, length = 50, columnDefinition="default 'a'")
    private String uname;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD", nullable = false, length = 50, columnDefinition="default '1'")
    private String password;
    
//    @Size(max = 50)
//    @Column(name = "MAJOR", length = 50)
//    private String major;
//    
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
//    @Column(name = "SUBMAJOR", nullable = false, length = 50, columnDefinition="default 'a'")
//    private String submajor;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    
    
//    @JoinColumn(name = "ID", referencedColumnName = "STID", nullable = false, insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Stcot stcot;
//    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stt")
//    private Collection<Submajor> submajorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "stt")
    private Dept dept;

    public Stt() {
    }

    public Stt(Integer id) {
        this.id = id;
    }

    public Stt(Integer id, String name, String uname, String password) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.password = password;
//        this.submajor = submajor;
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

//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }
//
//    public String getSubmajor() {
//        return submajor;
//    }
//
//    public void setSubmajor(String submajor) {
//        this.submajor = submajor;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Stcot getStcot() {
//        return stcot;
//    }

//    public void setStcot(Stcot stcot) {
//        this.stcot = stcot;
//    }

//    @XmlTransient
//    public Collection<Submajor> getSubmajorCollection() {
//        return submajorCollection;
//    }

//    public void setSubmajorCollection(Collection<Submajor> submajorCollection) {
//        this.submajorCollection = submajorCollection;
//    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

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
        return "com.sbu.dao.model.Stt[ id=" + id + " ]";
    }
    
}
