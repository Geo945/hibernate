package com.example.hibernate.Services;

import com.example.hibernate.Model.Laptop;
import com.example.hibernate.Model.Student;
import com.example.hibernate.Repositorys.LaptopRepository;
import com.example.hibernate.Repositorys.StudentRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;
import java.util.List;

@Service
public class StudentServices {


    private final StudentRepository repo;
    private final LaptopRepository laptoprepo;


    @Autowired
    public StudentServices(StudentRepository repo, LaptopRepository laptoprepo) {
        this.repo = repo;
        this.laptoprepo = laptoprepo;
    }

    public List<Student> getStudents() {
        //because level 1 caching is by default
        //the query for repo.findAll() is filed only once not 3 times
        //the last 2 times it will take the result from the level 1 cache memory

        System.out.println(repo.getStudentById(1));
        List<Student> students = repo.HQMquery();
        for(Student s:students) {
            System.out.println(s);
        }
        System.out.println(repo.getMarian());

        Object[] student = repo.getNameAndUniversity();

        for(Object o: student){
            System.out.println(o);
        }
        System.out.println(student[0]);

        List<Object[]> allstudents = repo.getAsList();
        for(Object[] s : allstudents){
            System.out.println(s[0] + " " + s[1]);
        }

        List<Object[]> idGreaterThan20 = repo.getWithIdGreaterThan20();
        for(Object[] s : idGreaterThan20){
            System.out.println(s[0] + " " + s[1]);
        }

        Integer total_sum = repo.getSum();
        System.out.println(total_sum);

        Object total_sum2 = repo.getSum2(2);
        System.out.println(total_sum2);



        return repo.findAll();
    }
}
