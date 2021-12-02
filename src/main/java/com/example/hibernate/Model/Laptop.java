package com.example.hibernate.Model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

//Note - if you want to cache your @OneToMany or @ManyToOne relation - add @Cache annotation over this field as well.


@Entity
@Cacheable//for second level caching.
//not all classes are cacheable so this is why we specify this with @Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//this is the strategy.
//So second level cacheing will work for both read(save to db) and write(update db). We can also have CacheConcurrencyStrategy.READ_ONLY so second level cacheing will work only for read.

public class Laptop {
    @Id
    private Integer lid;
    private String lname;

    @ManyToOne//pentru @OneToMany in student
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Student student;

    public Laptop(int lid, String lname, Student student) {
        this.lid = lid;
        this.lname = lname;
        this.student=student;
    }

    public Laptop() {

    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", student=" + student +
                '}';
    }
}
