/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pegah
 */
@Entity
@Table(name = "PROF", catalog = "NEET", schema = "PUBLIC", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"DID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prof.findAll", query = "SELECT p FROM Prof p")
    , @NamedQuery(name = "Prof.findById", query = "SELECT p FROM Prof p WHERE p.id = :id")
    , @NamedQuery(name = "Prof.findByName", query = "SELECT p FROM Prof p WHERE p.name = :name")
    , @NamedQuery(name = "Prof.findByUname", query = "SELECT p FROM Prof p WHERE p.uname = :uname")
    , @NamedQuery(name = "Prof.findByPass", query = "SELECT p FROM Prof p WHERE p.pass = :pass")
    , @NamedQuery(name = "Prof.findByEmail", query = "SELECT p FROM Prof p WHERE p.email = :email")
    , @NamedQuery(name = "Prof.findByDid", query = "SELECT p FROM Prof p WHERE p.did = :did")
    , @NamedQuery(name = "Prof.findByColumn8", query = "SELECT p FROM Prof p WHERE p.column8 = :column8")})
public class Prof implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
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
    @Column(name = "PASS", nullable = false, length = 50, columnDefinition="default 'a'")
    private String pass;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL", nullable = false, length = 50, columnDefinition="default 'a'")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "IMAGE", nullable = false, columnDefinition="default '0'")
    private Serializable image;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DID", nullable = false, columnDefinition="default '1'")
    private int did;
    @Column(name = "COLUMN_8")
    private Integer column8;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prof")
    private Dept dept;
//    @JoinColumn(name = "ID", referencedColumnName = "PID", nullable = false, insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Termcourse termcourse;

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
        this.image = image;
        this.did = did;
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

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        this.image = image;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Integer getColumn8() {
        return column8;
    }

    public void setColumn8(Integer column8) {
        this.column8 = column8;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

//    public Termcourse getTermcourse() {
//        return termcourse;
//    }

//    /

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
