package com.example.hibernate.Repositorys;

import com.example.hibernate.Model.Student;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Student getStudentById(Integer id);
    //daca am un query ca cel de sus si vreau sa dau enable la second level caching pt el trb sa pui @QueryHints de mai sus


    //HQL Queries
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("from Student")
    List<Student> HQMquery();

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("from Student where name='Marian'")//
    Student getMarian();

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("select name,university from Student where name='Name1'")
    Object[] getNameAndUniversity();

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("select name,university from Student")
    List<Object[]> getAsList();

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("select s.id,s.name,s.university from Student s where s.id>20")
    List<Object[]> getWithIdGreaterThan20();

    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("select sum(id) from Student where id>25")//face suma cu id-urile >25
    Integer getSum();


    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    @Query("select sum(s.id) from Student s where s.id > :#{#id}")//face suma cu id-urile mai mari decat Integer id dat ca parametru la functie
    Integer getSum2(@Param("id") Integer id);




}
