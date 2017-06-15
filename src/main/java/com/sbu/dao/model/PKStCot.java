package com.sbu.dao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Pegah on 6/10/2017.
 */
@Embeddable
public class PKStCot implements Serializable {


    @Column(name = "coid")
    private Integer course;

    @Column(name = "stid")

    private Integer student;

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer stId) {
        this.student = stId;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer coId) {
        this.course = coId;
    }

}
