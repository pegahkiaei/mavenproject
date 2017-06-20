package com.sbu.dao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by Pegah on 6/16/2017.
 */
@Embeddable
public class PKCoMajt implements Serializable {


    @Column(name = "coId",nullable = false)
    private Integer courseid;

    @Column(name = "submajorId", nullable = false)
    private Integer submajorid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "filterId", nullable = false)//TODO: generated type
    private Integer filterid;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getSubmajorid() {
        return submajorid;
    }

    public void setSubmajorid(Integer submajorid) {
        this.submajorid = submajorid;
    }

    public Integer getFilterid() {
        return filterid;
    }

    public void setFilterid(Integer filterid) {
        this.filterid = filterid;
    }
}
