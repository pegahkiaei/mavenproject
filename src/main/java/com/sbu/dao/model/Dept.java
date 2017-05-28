/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.dao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pegah
 */
@Entity
@Table(name = "DEPT", catalog = "NEET", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
    , @NamedQuery(name = "Dept.findByDid", query = "SELECT d FROM Dept d WHERE d.did = :did")
    , @NamedQuery(name = "Dept.findByPid", query = "SELECT d FROM Dept d WHERE d.pid = :pid")
    , @NamedQuery(name = "Dept.findByName", query = "SELECT d FROM Dept d WHERE d.name = :name")
    , @NamedQuery(name = "Dept.findByUname", query = "SELECT d FROM Dept d WHERE d.uname = :uname")
    , @NamedQuery(name = "Dept.findByPasswoed", query = "SELECT d FROM Dept d WHERE d.passwoed = :passwoed")})
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DID", nullable = false)
    private Integer did;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PID", nullable = false, columnDefinition="default '1'")
    private int pid;
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
    @Column(name = "PASSWOED", nullable = false, length = 50, columnDefinition="default 'a'")
    private String passwoed;
    
//    @JoinColumn(name = "DID", referencedColumnName = "DEPID", nullable = false, insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Cot cot;
    
    @JoinColumn(name = "DID", referencedColumnName = "DID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prof prof;
    
//    @JoinColumn(name = "DID", referencedColumnName = "MAJOR", nullable = false, insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Stt stt;
    
//    @JoinColumn(name = "DID", referencedColumnName = "MAJORID", nullable = false, insertable = false, updatable = false)
//    @OneToOne(optional = false)
//    private Submajor submajor;

    public Dept() {
    }

    public Dept(Integer did) {
        this.did = did;
    }

    public Dept(Integer did, int pid, String name, String uname, String passwoed) {
        this.did = did;
        this.pid = pid;
        this.name = name;
        this.uname = uname;
        this.passwoed = passwoed;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public String getPasswoed() {
        return passwoed;
    }

    public void setPasswoed(String passwoed) {
        this.passwoed = passwoed;
    }

//    public Cot getCot() {
//        return cot;
//    }

//    public void setCot(Cot cot) {
//        this.cot = cot;
//    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

//    public Stt getStt() {
//        return stt;
//    }

//    public void setStt(Stt stt) {
//        this.stt = stt;
//    }

//    public Submajor getSubmajor() {
//        return submajor;
//    }

//    public void setSubmajor(Submajor submajor) {
//        this.submajor = submajor;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (did != null ? did.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.did == null && other.did != null) || (this.did != null && !this.did.equals(other.did))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sbu.dao.model.Dept[ did=" + did + " ]";
    }
    
}
