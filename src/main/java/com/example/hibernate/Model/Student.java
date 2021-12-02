package com.example.hibernate.Model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Cacheable//from second level caching.
//not all classes are cacheable so this is why we specify this with @Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//this is the strategy.
//So second level cacheing will work for both read(save to db) and write(update db). We can also have CacheConcurrencyStrategy.READ_ONLY so second level cacheing will work only for read.
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String university;
    /*Pentru OneToOne relation
    @OneToOne//asa baza de date va contine campul laptop_lid care reprezinta un id a unui laptop din baza de date, dar nu va contine obiectul laptop propriu zis. avem nevoie de o alta baza de date ce contine obiecte Laptop.
    private Laptop laptop;
    */

    @OneToMany(mappedBy = "student",fetch=FetchType.EAGER)
    //by default fetchType is lazy so it will fetch the value only when you need it, but you want eager to fetch it always
    //cand folosesc asta trb si @ManyToOne in clasa Laptop deasupra lui private Student student;
    //@OneToMany(mappedBy = "student") student is variable from class Student, write this so it wont create 3rd table because the mapping will be done by student.
    //Before the mapping was done by both student and laptop
    //si atunci in laptop table fiecare laptop o sa aiba un student_id
   @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)//because use OneToMany
    private List<Laptop> laptop = new ArrayList<Laptop>();


    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    public Student(String name, String university) {
        this.name = name;
        this.university = university;

    }

    public Student() {

    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                '}';
    }

}
